package com.sprint.mission.discodeit.service;

import java.util.List;
import java.util.UUID;

public interface DomainService<F, C, U> {
    F create(C model);

    F find(UUID id);

    List<F> findAll();

    F update(U model);

    void delete(UUID id);
}
