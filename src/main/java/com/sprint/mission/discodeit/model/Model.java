package com.sprint.mission.discodeit.model;

import com.sprint.mission.discodeit.entity.Entity;

import java.util.*;

public class Model<T extends Entity<T>> {
    private final Map<UUID, T> data;

    public Model() {
        this(new HashMap<>());
    }

    public Model(Map<UUID, T> data) {
        this.data = data;
    }

    public boolean containsKey(UUID key) {
        return data.containsKey(key);
    }

    public T get(UUID key) {
        return data.get(key).copy();
    }

    public List<T> getAll(List<UUID> keys) {
        return keys.stream()
                .map(key -> Optional.ofNullable(data.get(key)))
                .flatMap(Optional::stream)
                .map(T::copy)
                .toList();
    }

    public void remove(UUID key) {
        data.remove(key);
    }

    public void add(UUID key, T value) {
        data.put(key, value);
    }

    public void update(UUID key, String value) {
        T entity = data.get(key);
        entity.update(value);
    }
}
