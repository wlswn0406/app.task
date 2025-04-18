package app.task.system.log;

import app.task.api.AbstractController;
import app.task.common.util.LoggerUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/api")
//@RequiredArgsConstructor
public class LogController extends AbstractController {

    private static final Logger log = LoggerUtil.getLogger(LogController.class);

    //private final LogService logService;

    // [todo] 화면에서 로그 조회시
    
}