package com.sprint.mission.discodeit.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@RequiredArgsConstructor
@Getter
@ToString
public class Message implements Serializable {
    @ToString.Exclude
    private static final long serialVersionUID = 1L;

    private final UUID id = UUID.randomUUID();
    private final Long createdAt = Instant.now().getEpochSecond();
    private Long updatedAt = createdAt;
    //
    @NonNull
    private String content;
    @NonNull
    private UUID channelId;
    @NonNull
    private UUID authorId;

    public void update(String newContent) {
        boolean anyValueUpdated = false;
        if (newContent != null && !newContent.equals(this.content)) {
            this.content = newContent;
            anyValueUpdated = true;
        }

        if (anyValueUpdated) {
            this.updatedAt = Instant.now().getEpochSecond();
        }
    }
}
