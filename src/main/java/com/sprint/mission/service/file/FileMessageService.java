package com.sprint.mission.service.file;

import com.sprint.mission.entity.Channel;
import com.sprint.mission.entity.Message;
import com.sprint.mission.entity.User;
import com.sprint.mission.service.MessageService;

public class FileMessageService extends FileBaseService<Message, MessageService> implements MessageService {

    public FileMessageService(MessageService service) {
        super(service, "msg");
    }

    @Override
    public Message create(User user, Channel channel, String content) {
        MessageService service = getService();
        Message message = service.create(user, channel, content);
        save(message);
        return message;
    }
}
