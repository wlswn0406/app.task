package app.task.api.auth;

import app.task.api.AbstractController;
import app.task.api.auth.dto.LoginDTO;
import app.task.api.auth.dto.LoginResponseDTO;
import app.task.api.auth.dto.SignupDTO;
import app.task.common.ApiResponse;
import app.task.common.util.LoggerUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 사용자 가입, 로그인, 토큰 발급 등 인증 관련 API를 제공하는 컨트롤러
 *
 */
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController extends AbstractController {

    private static final Logger log = LoggerUtil.getLogger(AuthController.class);

    private final AuthService authService;

    // [todo] 회원 가입
    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<?>> signup(@RequestBody @Valid SignupDTO signupDTO) {
        return null;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<?>> login(@RequestBody @Valid LoginDTO loginDTO) {

        LoginResponseDTO result = authService.login(loginDTO);

        if(result == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(ApiResponse.error("아이디 또는 비밀번호가 올바르지 않습니다"));
        }

        return ResponseEntity.ok(ApiResponse.success(result));
    }

    // [todo] 로그아웃
    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<Void>> logout(@RequestHeader("Authorization") String token) {
        return null;
    }
    
}