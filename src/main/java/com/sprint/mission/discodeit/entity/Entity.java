package com.sprint.mission.discodeit.entity;

import java.util.UUID;

public abstract class Entity {
    // convert milliseconds to seconds
    private final long MILLISECONDS = 1000;
    private final UUID uuid;
    private final long createdAt;
    private long updatedAt;

    public Entity() {
        this.uuid = UUID.randomUUID();
        this.createdAt = getUnixTime();
        this.updatedAt = this.createdAt;
    }

    private long getUnixTime() {
        return System.currentTimeMillis() / MILLISECONDS;
    }

    protected void updateTime() {
        this.updatedAt = getUnixTime();
    }

    public UUID getUuid() {
        return uuid;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public abstract void update(String value);
}
