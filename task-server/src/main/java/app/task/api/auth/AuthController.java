package app.task.api.auth;

import app.task.api.AbstractController;
import app.task.api.user.UserService;
import app.task.common.ApiResponse;
import app.task.common.util.LoggerUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController extends AbstractController {

    private static final Logger log = LoggerUtil.getLogger(AuthController.class);

    // [todo] 로그인
    @GetMapping("/login")
    public ResponseEntity<ApiResponse<?>> login() {
        return null;
    }

}