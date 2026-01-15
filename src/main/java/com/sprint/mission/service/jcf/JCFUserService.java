package com.sprint.mission.service.jcf;

import com.sprint.mission.entity.User;
import com.sprint.mission.service.UserService;
import com.sprint.mission.service.validation.Validation;

import java.util.*;

public class JCFUserService implements UserService, Validation {
    private final Map<UUID, User> users;

    public JCFUserService() {
        this.users = new HashMap<>();
    }

    @Override
    public User create(String userId) {
        validateNotNull(userId);
        User user = new User(userId);
        users.put(user.getUuid(), user);
        return user;
    }

    @Override
    public User get(UUID uuid) {
        validateNotNull(uuid);
        validateHavingUUID(uuid, users);
        return users.get(uuid);
    }

    @Override
    public List<User> getAll(List<UUID> uuids) {
        validateNotNull(uuids);
        return uuids.stream().map(this::get).toList();
    }

    @Override
    public void update(UUID uuid, String newUserId) {
        validateNotNull(newUserId);
        User user = get(uuid);
        user.update(newUserId);
    }

    @Override
    public void delete(UUID uuid) {
        validateNotNull(uuid);
        validateHavingUUID(uuid, users);
        users.remove(uuid);
    }
}
