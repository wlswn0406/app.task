package app.task.common.filter;

import app.task.api.auth.AuthService;
import app.task.api.auth.JwtTokenProvider;
import app.task.api.user.UserMapper;
import app.task.common.util.SessionUtil;
import app.task.domain.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    private final AuthService authService;

    private static final List<String> EXCLUDE_URLS =
            Arrays.asList("/auth/signup", "/auth/login", "/auth/refresh");

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getServletPath();
        return EXCLUDE_URLS.stream().anyMatch(path::startsWith);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        String token = this.getJwtFromRequest(request);

        // 토큰이 존재하고 유효한 경우
        if(token != null && jwtTokenProvider.validateToken(token)) {
            String userId = jwtTokenProvider.getUserId(token);

            // 토큰 정보와 세션 정보가 일치하며 통과
            if(session != null) {
                if(userId.equals(SessionUtil.getCurrentUserId(session))) {
                    filterChain.doFilter(request, response);
                    return;
                }
            }

            // 세션에 사용자가 없다면 검증
            User user = authService.findById(userId);
            if(user == null) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("User not found");
                return;
            }
            SessionUtil.setCurrentUserId(request.getSession(), userId);
            filterChain.doFilter(request, response);
            return;

        // 토큰이 없거나 유효하지 않은 경우
        } else {
            if(session != null) {
                SessionUtil.removeCurrentUserId(session);
            }
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Authentication required");
            return;
        }

    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if(bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

}