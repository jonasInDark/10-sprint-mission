package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.ChannelService;
import com.sprint.mission.discodeit.service.ChatService;
import com.sprint.mission.discodeit.service.MessageService;
import com.sprint.mission.discodeit.service.UserService;

import java.util.List;
import java.util.UUID;

public class JCFDiscordService implements ChatService {
    private final UserService userService;
    private final ChannelService channelService;
    private final MessageService messageService;

    public JCFDiscordService() {
        this(new JCFUserService(), new JCFChannelService(), new JCFMessageService());
    }

    public JCFDiscordService(UserService userService,
                             ChannelService channelService,
                             MessageService messageService) {
        this.userService = userService;
        this.channelService = channelService;
        this.messageService = messageService;
    }

    @Override
    public void createUser(User user) {
        userService.createUser(user);
    }

    @Override
    public void createChannel(Channel channel) {
        channelService.createChannel(channel);
    }

    @Override
    public void addUserToChannel(User user, Channel channel) {
        userService.addChannel(user, channel);
        channelService.addUser(channel, user);
    }

    @Override
    public void sendMessageToChannel(User user, Channel channel, Message message) {
        userService.sendMessage(user, message);
        channelService.addMessage(channel, message);
        messageService.createMessage(message);
    }

    @Override
    public void changeUserId(User user, User newUser) {
        userService.changeUser(user, newUser);
    }

    @Override
    public void changeChannelId(Channel channel, Channel newChannel) {
        channelService.changeChannelId(channel, newChannel);
    }

    @Override
    public void changeMessage(Message message, Message newMessage) {
        messageService.changeMessage(message, newMessage);
    }

    @Override
    public void deleteUser(User user) {
        List<UUID> messageUUIDs = userService.getMessageUUIDs(user);
        messageService.deleteMessages(messageUUIDs);
        List<UUID> channelUUIDs = userService.getChannelUUIDs(user);
        channelService.deleteUserFromChannels(user, channelUUIDs);
        userService.deleteUser(user);
    }

    @Override
    public void deleteChannel(Channel channel) {
        List<UUID> messageUUIDs = channelService.getMessageUUIDs(channel);
        messageService.deleteMessages(messageUUIDs);
        List<UUID> userUUIDs = channelService.getUserUUIDs(channel);
        userService.deleteChannelFromUsers(channel, userUUIDs);
        channelService.deleteChannel(channel);
    }

    @Override
    public void deleteMessage(User user, Channel channel, Message message) {
        messageService.deleteMessage(message);
        userService.deleteMessage(user, message);
        channelService.deleteMessage(channel, message);
    }
}
