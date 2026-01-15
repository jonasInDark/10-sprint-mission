package com.sprint.mission.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User extends Entity {
    private String userId;
    private final List<UUID> channelUUIDs;
    private final List<UUID> messageUUIDs;

    public User(String userId) {
        super();
        this.userId = userId;
        this.channelUUIDs = new ArrayList<>();
        this.messageUUIDs = new ArrayList<>();
    }

    @Override
    public void update(String userId) {
        this.userId = userId;
        updateTime();
    }

    public void addChannelUUID(UUID uuid) {
        this.channelUUIDs.add(uuid);
    }

    public void addMessageUUID(UUID uuid) {
        this.messageUUIDs.add(uuid);
    }

    public String getUserId() {
        return userId;
    }

    public List<UUID> getChannelUUIDs() {
        return List.copyOf(channelUUIDs);
    }

    public List<UUID> getMessageUUIDs() {
        return List.copyOf(messageUUIDs);
    }
}
