package app.task.api;

import app.task.common.util.SessionUtil;
import jakarta.servlet.http.HttpServletRequest;

/**
 * 컨트롤러를 위한 공통 설정을 제공하는 추상 클래스
 *
 */
public abstract class AbstractController {

    // [todo] 공통 헤더
    // [todo] 공통 응답
    // [todo] 예외 처리

    protected String getCurrentUserId(HttpServletRequest request) {
        return SessionUtil.getCurrentUserId(request.getSession());
    }

}