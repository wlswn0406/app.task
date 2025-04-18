package app.task.api.user;

import app.task.api.AbstractController;
import app.task.common.util.LoggerUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController extends AbstractController {

    private static final Logger log = LoggerUtil.getLogger(UserController.class);

    private final UserService userService;

}