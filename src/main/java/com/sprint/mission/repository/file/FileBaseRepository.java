package com.sprint.mission.repository.file;

import com.sprint.mission.entity.Entity;
import com.sprint.mission.repository.BaseRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileBaseRepository<T extends Entity<T>> implements BaseRepository<T> {
    private final String extension;
    private final Path saveDirectory;

    public FileBaseRepository(String extension) {
        this.extension = extension;
        this.saveDirectory = Path.of(System.getProperty("user.dir"), "repository", extension);
        try {
            Files.createDirectories(saveDirectory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getFileName(UUID id) {
        return String.join(".", id.toString(), extension);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T read(UUID id) {
        Path path = saveDirectory.resolve(getFileName(id));
        try (
                FileInputStream fis = new FileInputStream(path.toFile());
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <U extends Collection<UUID>> Map<UUID, T> readMany(U ids) {
        return ids.stream()
                .map(this::read)
                .collect(Collectors.toMap(Entity::getId, entity -> entity));
    }

    @Override
    public void write(T entity) {
        Path path = saveDirectory.resolve(getFileName(entity.getId()));
        try (
                FileOutputStream fos = new FileOutputStream(path.toFile());
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(entity);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeMany(Map<UUID, T> entities) {
        entities.values().forEach(this::write);
    }

    @Override
    public boolean hasId(UUID id) {
        try (Stream<Path> fileList = Files.list(saveDirectory);) {
            return fileList
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .map(fileName -> fileName.replace("." + extension, "")) // remove extension
                    .anyMatch(entityId -> entityId.equals(id.toString()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
