package app.task.system.log;

import java.time.LocalDateTime;

/**
 * 시스템 로그 도메인
 * 
 */
public record Log(
    Integer id,
    Integer referenceId,
    LogType logType,
    String logMessage,
    String actor,
    LocalDateTime createdAt
) {}