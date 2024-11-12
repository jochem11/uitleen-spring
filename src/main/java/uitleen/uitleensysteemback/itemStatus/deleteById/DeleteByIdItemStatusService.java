package uitleen.uitleensysteemback.itemStatus.deleteById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.itemStatus.ItemStatusRepository;

@Service
public class DeleteByIdItemStatusService {
    private final ItemStatusRepository itemStatusRepository;

    @Autowired
    public DeleteByIdItemStatusService(final ItemStatusRepository itemStatusRepository) {
        this.itemStatusRepository = itemStatusRepository;
    }

    public void deleteById(final long itemStatusId) {
        itemStatusRepository.deleteById(itemStatusId);
    }
}
