package com.sprint.mission.discodeit.service;

import com.sprint.mission.discodeit.dto.BinaryContentServiceDTO.BinaryContentCreation;
import com.sprint.mission.discodeit.dto.BinaryContentServiceDTO.BinaryContentResponse;
import com.sprint.mission.discodeit.dto.BinaryContentServiceDTO.BinaryContentUpdate;

import java.util.List;
import java.util.UUID;

public interface BinaryContentService extends DomainService<BinaryContentResponse, BinaryContentCreation, BinaryContentUpdate> {
    List<BinaryContentResponse> findAllByIdIn(List<UUID> ids);
}
