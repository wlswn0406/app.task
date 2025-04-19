package app.task.domain;

import java.time.LocalDateTime;

/**
 * 사용자 도메인
 *
 */
public record User(
    Integer uid,
    String id,
    String password,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    LocalDateTime lastLoginAt
) {}