package com.sprint.mission;

import com.sprint.mission.entity.User;
import com.sprint.mission.service.UserService;
import com.sprint.mission.service.jcf.JCFServiceFactory;

import java.util.UUID;

public class JavaApplication {
    public static void testUserService() {
        UserService userService = JCFServiceFactory.getUserService();

        User user1 = userService.create("jonas");
        System.out.printf("user id: %s, name: %s%n", user1.getId(), user1.getUserName());

        if (user1.equals(userService.get(user1.getId()))) {
            System.out.println("same user");
        }
        User user2 = userService.create("lee");
        if (!user1.equals(user2)) {
            System.out.println("different user");
        }
        UUID userid1 = user1.getId();
        userService.update(userid1, "jonas in dark");
        System.out.printf("user id: %s, name: %s%n", user1.getId(), user1.getUserName());

        userService.delete(userid1);
        System.out.println("delete user1");
        try {
            userService.get(userid1);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
    }

    public static void main(String[] args) {
        testUserService();
    }
}