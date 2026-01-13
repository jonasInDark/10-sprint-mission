package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.Entity;
import com.sprint.mission.discodeit.model.Model;
import com.sprint.mission.discodeit.service.ModelManager;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

public class JCFModelManager<T extends Entity<T>> implements ModelManager<T> {
    private final Model<T> model;
    private final Function<String, T> factory;

    public JCFModelManager(Model<T> model, Function<String, T> factory) {
        this.model = model;
        this.factory = factory;
    }

    @Override
    public void create(String value) {
        T entity = factory.apply(value);
        model.add(entity.getUuid(), entity);
    }

    @Override
    public Optional<T> read(UUID uuid) {
        return Optional.ofNullable(model.get(uuid));
    }

    @Override
    public List<T> readAll(List<UUID> uuids) {
        return model.getAll(uuids);
    }

    @Override
    public void update(UUID uuid, String value) {
        if (model.containsKey(uuid)) {
            model.update(uuid, value);
        }
    }

    @Override
    public void delete(UUID key) {
        if (model.containsKey(key)) {
            model.remove(key);
        }
    }
}
