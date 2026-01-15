package com.sprint.mission.service.validation;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public interface Validation {
    default void validateNotNull(Object obj, Object... objects) {
        validateNotNull(obj);
        Arrays.stream(objects).forEach(this::validateNotNull);
    }

    private void validateNotNull(Object obj) {
        String msg = "input is null";
        if (obj instanceof UUID) {
            msg = "uuid is null";
        }
        if (Objects.isNull(obj)) {
            throw new IllegalArgumentException(msg);
        }
    }

    default void validateHavingUUID(UUID uuid, Map<UUID, ?> data) {
        if (!data.containsKey(uuid)) {
            throw new IllegalArgumentException(String.format("UUID %s don't exist", uuid));
        }
    }
}
