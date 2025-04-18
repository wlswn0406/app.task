package app.task.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public final class LoggerUtil {

    public static Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    public static void logInfoIfTest(Class<?> clazz, String message) {
        String profile = System.getProperty("spring.profiles.active");
        if("test".equals(profile)) {
            getLogger(clazz).info(message);
        }
    }

}