package app.task.common.aop;

import app.task.common.util.LoggerUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LoggerUtil.getLogger(LoggingAspect.class);

    @Around("execution(* app.task.api..*Controller.*(..))")
    public Object logController(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().toShortString();
        log.info("==> 호출: {}", methodName);

        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();

        log.info("<== 완료: {} ({}ms)", methodName, (end - start));

        return result;
    }

}