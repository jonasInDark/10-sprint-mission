package com.sprint.mission.discodeit.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@ToString
public class UserStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    private final long ACTIVE_THRESHOLD = 300L;

    @Getter
    private final UUID id = UUID.randomUUID();
    private final long createdAt = Instant.now().getEpochSecond();
    private long updatedAt = createdAt;
    @Setter
    private long lastActiveTime = createdAt;

    public boolean isActive() {
        long now = Instant.now().getEpochSecond();
        return (now - lastActiveTime) < ACTIVE_THRESHOLD;
    }
}
