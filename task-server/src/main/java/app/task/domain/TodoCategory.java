package app.task.domain;

import java.time.LocalDateTime;

/**
 * 할 일 카테고리 도메인
 *
 */
public record TodoCategory(
    Integer cid,
    String name,
    Integer sortOrder,
    Boolean isChecked,
    Boolean isDeleted,
    Integer createdBy,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {}