package app.task.api.calendar;

import app.task.api.AbstractController;
import app.task.common.util.LoggerUtil;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CalendarController extends AbstractController {

    private static final Logger log = LoggerUtil.getLogger(CalendarController.class);
    
}