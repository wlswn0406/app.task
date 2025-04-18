package app.task.domain;

import java.time.LocalDateTime;

/**
 * 사용자 도메인
 * - 로그인을 위한 사용자 정보를 확인하기 위한 용도
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