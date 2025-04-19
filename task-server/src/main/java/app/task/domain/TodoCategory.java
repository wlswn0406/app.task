package app.task.domain;

import java.time.LocalDateTime;

/**
 * 할 일 카테고리 도메인
 *
 */
public record TodoCategory(
    Integer cid,
    Integer userId,
    String name,
    Integer sortOrder,
    Boolean isChecked,
    String userName,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {}