package app.task.domain;

import java.time.LocalDateTime;

/**
 * 할 일 도메인
 * - 할 일에 대한 정보를 읽기 위한 용도
 * 
 */
public record Todo(
    Integer tid,
    Integer categoryId,
    String title,
    String description,
    Integer sortOrder,
    Boolean isDone,
    Boolean isImportant,
    Boolean isNotified,
    Integer createdBy,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {}