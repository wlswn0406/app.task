package app.task.domain;

import java.time.LocalDateTime;

/**
 * 할 일 도메인
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
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {}