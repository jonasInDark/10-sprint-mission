package com.sprint.mission.discodeit.service;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.entity.User;

public interface ChatService {
    void createUser(User user);

    void createChannel(Channel channel);

    void addUserToChannel(User user, Channel channel);

    void sendMessageToChannel(User user, Channel channel, Message message);

    void changeUserId(User user, User newUser);

    void changeChannelId(Channel channel, Channel newChannel);

    void changeMessage(Message message, Message newMessage);

    void deleteUser(User user);

    void deleteChannel(Channel channel);

    void deleteMessage(User user, Channel channel, Message message);
}
