package com.sprint.mission.service;

import com.sprint.mission.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User create(String userId);
    User get(UUID uuid);
    List<User> getAll(List<UUID> uuids);
    void update(UUID uuid, String newUserId);
    void delete(UUID uuid);
}
