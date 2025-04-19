package app.task.domain;

import app.task.domain.enums.NotifyStatus;
import app.task.domain.enums.NotifyType;

import java.time.LocalDateTime;

/**
 * 할 일 알림 도메인
 *
 */
public record TodoNoti(
    Integer nid,
    Integer todoId,
    Boolean isNotified,
    LocalDateTime notifyAt,
    NotifyType notifyType,
    NotifyStatus notifyStatus,
    LocalDateTime createdAt
) {}
