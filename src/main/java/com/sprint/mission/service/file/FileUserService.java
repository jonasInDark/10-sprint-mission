package com.sprint.mission.service.file;

import com.sprint.mission.entity.User;
import com.sprint.mission.service.UserService;

public class FileUserService extends FileBaseService<User, UserService> implements UserService {

    public FileUserService(UserService service) {
        super(service, "user");
    }

    @Override
    public User create(String userName) {
        UserService service = getService();
        User user = service.create(userName);
        save(user);
        return user;
    }
}
