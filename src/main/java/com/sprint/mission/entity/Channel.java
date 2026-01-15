package com.sprint.mission.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Channel extends Entity {
    private String channelId;
    private final List<UUID> messageUUIDs;
    private final List<UUID> userUUIDs;

    public Channel(String channelId) {
        super();
        this.channelId = channelId;
        this.messageUUIDs = new ArrayList<>();
        this.userUUIDs = new ArrayList<>();
    }

    @Override
    public void update(String channelId) {
        this.channelId = channelId;
        updateTime();
    }

    public void addUserUUID(UUID uuid) {
        this.userUUIDs.add(uuid);
    }

    public void addMessageUUID(UUID uuid) {
        this.messageUUIDs.add(uuid);
    }

    public String getChannelId() {
        return channelId;
    }

    public List<UUID> getMessageUUIDs() {
        return List.copyOf(messageUUIDs);
    }

    public List<UUID> getUserUUIDs() {
        return List.copyOf(userUUIDs);
    }
}
