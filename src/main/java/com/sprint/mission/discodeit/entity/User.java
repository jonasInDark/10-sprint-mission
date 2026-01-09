package com.sprint.mission.discodeit.entity;

public class User extends Entity<User> {
    private String userId;

    protected User(User entity) {
        super(entity);
        this.userId = entity.userId;
    }

    public User(String userId) {
        super();
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public void update(String userId) {
        this.userId = userId;
        updateTime();
    }

    @Override
    public User copy() {
        return new User(this);
    }
}
