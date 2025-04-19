package app.task.api.auth;

import app.task.api.auth.dto.LoginDTO;
import app.task.api.auth.dto.LoginResponseDTO;
import app.task.api.user.UserMapper;
import app.task.domain.Todo;
import app.task.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtTokenProvider jwtTokenProvider;

    private final UserMapper userMapper;

    public LoginResponseDTO login(LoginDTO loginDTO) {
        User user = userMapper.findById(loginDTO.getId());

        if(user == null) {
            return null;
        }

        // [todo] 비밀 번호 암호화 후 비교
        if(loginDTO.getPassword().equals(user.password()) == false) {
            return null;
        }

        String token = jwtTokenProvider.createToken(user.id());

        return LoginResponseDTO.builder()
                .token(token)
                .id(user.id())
                .build();
    }

}