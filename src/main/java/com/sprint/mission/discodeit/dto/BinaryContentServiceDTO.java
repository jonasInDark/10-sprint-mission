package com.sprint.mission.discodeit.dto;

import lombok.Builder;

import java.util.UUID;

public interface BinaryContentServiceDTO {
    static BinaryContentCreation getEmptyCreation() {
        return new BinaryContentCreation(null, null, null);
    }
    record BinaryContentCreation(String fileName, String fileType, byte[] data) {}
    @Builder
    record BinaryContentResponse(UUID id, String fileName, String fileType, byte[] data) {}
}
