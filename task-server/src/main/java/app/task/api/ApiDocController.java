package app.task.api;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * API 문서 리다이렉트를 처리하는 컨트롤러
 * - 'test' 또는 'dev' 프로파일이 활성화된 환경에서만 API 문서를 제공하도록 설정
 *
 */
@RestController
@Profile({"test", "dev"})
@RequestMapping("/docs")
public class ApiDocController {

    @GetMapping
    public RedirectView redirectToDoc() {
        return new RedirectView("/docs/index.html");
    }

}