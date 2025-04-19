package app.task.common.util;

import jakarta.servlet.http.HttpSession;

public class SessionUtil {

    // 세션에서 사용자 ID를 반환
    public static String getCurrentUserId(HttpSession session) {
        return (String) session.getAttribute("userId");
    }

    // 세션에 사용자 ID를 설정
    public static void setCurrentUserId(HttpSession session, String userId) {
        session.setAttribute("userId", userId);
    }

    // 세션에서 사용자 ID 제거
    public static void removeCurrentUserId(HttpSession session) {
        session.removeAttribute("userId");
    }
    
}