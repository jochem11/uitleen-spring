package uitleen.uitleensysteemback.itemStatus.getById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.itemStatus.ItemStatusRepository;
import uitleen.uitleensysteemback.models.ItemStatus;

import java.util.Optional;

@Service
public class GetByIdItemStatusService {
    private final ItemStatusRepository itemStatusRepository;

    @Autowired
    public GetByIdItemStatusService(final ItemStatusRepository itemStatusRepository) {
        this.itemStatusRepository = itemStatusRepository;
    }

    public Optional<ItemStatus> getById(final long itemStatusId) {
        return itemStatusRepository.findById(itemStatusId);
    }
}
