package com.sprint.mission.discodeit.entity;

public class Channel extends Entity<Channel> {
    private String channelId;

    protected Channel(Channel entity) {
        super(entity);
        this.channelId = entity.channelId;
    }

    public Channel(String channelId) {
        super();
        this.channelId = channelId;
    }

    public String getChannelId() {
        return channelId;
    }

    @Override
    public void update(String channelId) {
        this.channelId = channelId;
        updateTime();
    }

    @Override
    public Channel copy() {
        return new Channel(this);
    }
}
