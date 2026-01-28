package com.sprint.mission.service.jcf;

import com.sprint.mission.dto.SendMsgVerificationRequest;
import com.sprint.mission.entity.Channel;
import com.sprint.mission.entity.Message;
import com.sprint.mission.entity.User;
import com.sprint.mission.service.MessageService;
import com.sprint.mission.service.validation.MessageServiceValidator;

import java.util.Objects;

public class JCFMessageService extends JCFBaseService<Message> implements MessageService {
    private static MessageService instance;
    private final MessageServiceValidator validator;

    private JCFMessageService(MessageServiceValidator validator) {
        super();
        this.validator = validator;
    }

    public static MessageService getInstance() {
        return Objects.requireNonNull(instance);
    }

    public static MessageService getInstance(MessageServiceValidator validator) {
        if (Objects.isNull(instance)) {
            instance = new JCFMessageService(validator);
        }
        return instance;
    }

    @Override
    public Message create(User user, Channel channel, String content) {
        validator.validateIdExist(
                new SendMsgVerificationRequest(user.getId(), channel.getId())
        );
        Message message = new Message(user, channel, content);
        getData().put(message.getId(), message);
        return message;
    }
}
