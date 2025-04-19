package app.task.system.log;

import java.time.LocalDateTime;

/**
 * 시스템 로그 도메인
 *
 * @param referenceId 로그가 참조하는 대상 테이블의 기본키
 * @param tableName 로그가 발생한 테이블 이름
 * @param logMessage 로그 상세 메시지
 * @param actor 로그 발생 주체 (SYSTEM or 사용자 아이디)
 * @param createdAt 로그 생성 시각
 */
public record Log(
    Integer id,
    Integer referenceId,
    TableName tableName,
    String logMessage,
    String actor,
    LocalDateTime createdAt
) {}