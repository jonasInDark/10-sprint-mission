package com.sprint.mission.discodeit.model;

import com.sprint.mission.discodeit.entity.Entity;

import java.util.*;

public class RelationModel<T extends Entity<T>, U extends Entity<U>> {
    private final Map<UUID, List<UUID>> data;

    public RelationModel() {
        this(new HashMap<>());
    }

    public RelationModel(Map<UUID, List<UUID>> data) {
        this.data = data;
    }

    public boolean containsKey(UUID key) {
        return data.containsKey(key);
    }

    public void initKey(UUID key) {
        data.put(key, new ArrayList<>());
    }

    public void add(UUID key, UUID value) {
        get(key, false).add(value);
    }

    public void remove(UUID key, UUID value) {
        get(key, false).remove(value);
    }

    public void removeKey(UUID key) {
        data.remove(key);
    }

    private List<UUID> get(UUID key, boolean isCopy) {
        return isCopy ? List.copyOf(data.get(key)) : data.get(key);
    }

    public List<UUID> get(UUID key) {
        return get(key, true);
    }
}
