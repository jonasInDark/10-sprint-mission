package com.sprint.mission;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.Entity;
import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.model.Model;
import com.sprint.mission.discodeit.model.RelationModel;
import com.sprint.mission.discodeit.service.*;
import com.sprint.mission.discodeit.service.jcf.*;

public class JavaApplication {
    public static ChatService discord;

    public static void init() {
        Model<User> userModel = new Model<>();
        Model<Channel> channelModel = new Model<>();
        Model<Message> messageModel = new Model<>();

        RelationModel<User, Channel> userChannelRelationModel = new RelationModel<>();
        RelationModel<User, Message> userMessageRelationModel = new RelationModel<>();
        RelationModel<Channel, User> channelUserRelationModel = new RelationModel<>();
        RelationModel<Channel, Message> channelMessageRelationModel = new RelationModel<>();

        ModelManager<User> userManager = new JCFModelManager<>(userModel);
        ModelManager<Channel> channelManager = new JCFModelManager<>(channelModel);
        ModelManager<Message> messageManager = new JCFModelManager<>(messageModel);

        RelationManager<User, Channel> userChannelRelationManager = new JCFRelationManager<>(userChannelRelationModel);
        RelationManager<User, Message> userMessageJCFRelationManager = new JCFRelationManager<>(userMessageRelationModel);
        RelationManager<Channel, User> channelUserRelationManager = new JCFRelationManager<>(channelUserRelationModel);
        RelationManager<Channel, Message> channelMessageRelationManager = new JCFRelationManager<>(channelMessageRelationModel);

        UserService userService = new JCFUserService(userManager, userMessageJCFRelationManager, userChannelRelationManager);
        ChannelService channelService = new JCFChannelService(channelManager, channelMessageRelationManager, channelUserRelationManager);
        MessageService messageService = new JCFMessageService(messageManager);
        ChatService discord = new JCFDiscordService(userService, channelService, messageService);
    }

    public static void test1() {
        User user1 = Entity.from("jonas", User::new);
        Channel channel1 = Entity.from("code-it", Channel::new);
        Message message1 = Entity.from("hello world!", Message::new);
        discord.createUser(user1);
        discord.createChannel(channel1);
        discord.sendMessageToChannel(user1, channel1, message1);
    }

    public static void test2() {

    }

    public static void main(String[] args) {
        init();
        test1();
    }
}