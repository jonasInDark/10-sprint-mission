package com.sprint.mission.discodeit.dto;

import lombok.NonNull;

import java.util.UUID;

public interface BinaryContentServiceDTO {
    record BinaryContentCreation(String url) {}
    record BinaryContentUpdate(@NonNull UUID id, String newUrl) {}
    record BinaryContentResponse(@NonNull UUID id, String url) {}
}
