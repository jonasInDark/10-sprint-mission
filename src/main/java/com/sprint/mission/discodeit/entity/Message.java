package com.sprint.mission.discodeit.entity;

public class Message extends Entity<Message> {
    private String message;

    protected Message(Message entity) {
        super(entity);
        this.message = entity.message;
    }

    public Message(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public void update(String message) {
        this.message = message;
        updateTime();
    }

    @Override
    public Message copy() {
        return new Message(this);
    }
}
