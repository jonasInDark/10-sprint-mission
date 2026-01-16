package com.sprint.mission.service;

import com.sprint.mission.entity.Message;

import java.util.UUID;

public interface MessageService extends BaseService<Message> {
    Message create(UUID userId, UUID channelId, String content);
}
