package app.task.api;

import app.task.it.ApiResponse;
import app.task.it.util.LoggerUtil;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 테스트용 API 컨트롤러
 *
 */
@RestController
@RequestMapping("/api")
public class TestController extends AbstractController {

    private static final Logger log = LoggerUtil.getLogger(TestController.class);

    @GetMapping("/test")
    public ResponseEntity<ApiResponse<?>> getTest() {
        log.info("===== TestController.getTest() =====");
        return ResponseEntity.ok(ApiResponse.success("테스트"));
    }

}