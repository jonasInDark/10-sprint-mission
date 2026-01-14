package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.service.MessageService;
import com.sprint.mission.discodeit.service.ModelManager;

import java.util.List;
import java.util.UUID;

public class JCFMessageService implements MessageService {
    private final ModelManager<Message> manager;

    public JCFMessageService(ModelManager<Message> manager) {
        this.manager = manager;
    }

    @Override
    public void createMessage(Message message) {
        manager.create(message.getMessage());
    }

    @Override
    public void changeMessage(Message oldMessage, Message newMessage) {
        manager.update(oldMessage.getUuid(), newMessage.getMessage());
    }

    @Override
    public void deleteMessage(Message message) {
        manager.delete(message.getUuid());
    }

    @Override
    public List<Message> getMessages(List<UUID> uuids) {
        return manager.readAll(uuids);
    }
}
