package com.sprint.mission.dto;

import java.util.UUID;

public record SendMsgVerificationRequest(UUID userId, UUID channelId) {
}
