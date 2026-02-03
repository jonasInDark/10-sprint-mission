package com.sprint.mission.discodeit.service.basic;

import com.sprint.mission.discodeit.dto.BinaryContentServiceDTO.BinaryContentCreation;
import com.sprint.mission.discodeit.dto.BinaryContentServiceDTO.BinaryContentResponse;
import com.sprint.mission.discodeit.dto.BinaryContentServiceDTO.BinaryContentUpdate;
import com.sprint.mission.discodeit.entity.BinaryContent;
import com.sprint.mission.discodeit.repository.BinaryContentRepository;
import com.sprint.mission.discodeit.service.BinaryContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BasicBinaryContentService implements BinaryContentService {
    private final BinaryContentRepository binaryContentRepository;

    @Override
    public List<BinaryContentResponse> findAllByIdIn(List<UUID> ids) {
        return ids.stream()
                .filter(binaryContentRepository::existsById)
                .map(this::find)
                .toList();
    }

    @Override
    public BinaryContentResponse create(BinaryContentCreation model) {
        BinaryContent content = new BinaryContent(model.url());
        binaryContentRepository.save(content);
        return content.toResponse();
    }

    private BinaryContent findBinaryContent(UUID id) {
        return binaryContentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Binary content with id, %s, not found".formatted(id)));
    }

    @Override
    public BinaryContentResponse find(UUID id) {
        return findBinaryContent(id).toResponse();
    }

    @Override
    public List<BinaryContentResponse> findAll() {
        return binaryContentRepository.findAll()
                .stream()
                .map(BinaryContent::toResponse)
                .toList();
    }

    @Override
    public BinaryContentResponse update(BinaryContentUpdate model) {
        throw new UnsupportedOperationException("Binary content can't be updated");
    }

    @Override
    public void delete(UUID id) {
        if (!binaryContentRepository.existsById(id)) {
            throw new NoSuchElementException("Binary Content with id, %s, not found".formatted(id));
        }
        binaryContentRepository.deleteById(id);
    }
}
