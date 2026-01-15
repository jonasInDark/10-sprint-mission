package com.sprint.mission.entity;

import java.util.UUID;

public abstract class Entity {
    private final UUID uuid;
    private final long createdAt;
    private long updatedAt;

    public Entity() {
        this.uuid = UUID.randomUUID();
        this.createdAt = getTimestamp();
        this.updatedAt = createdAt;
    }

    protected long getTimestamp() {
        return System.currentTimeMillis() / 1000;
    }

    public abstract void update(String value);

    protected void updateTime() {
        this.updatedAt = getTimestamp();
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public int hashCode() {
        return getUuid().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Entity entity) {
            return this.equals(entity);
        }
        return super.equals(obj);
    }
}
