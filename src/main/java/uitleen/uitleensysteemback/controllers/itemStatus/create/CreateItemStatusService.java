package uitleen.uitleensysteemback.controllers.itemStatus.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.itemStatus.ItemStatusRepository;
import uitleen.uitleensysteemback.models.ItemStatus;

@Service
public class CreateItemStatusService {
    private final ItemStatusRepository itemStatusRepository;

    @Autowired
    public CreateItemStatusService(final ItemStatusRepository itemStatusRepository) {
        this.itemStatusRepository = itemStatusRepository;
    }

    public void CreateItemStatus(final CreateItemStatusRequest request) {
        itemStatusRepository.save(mapRequestToItemStatus(request));
    }

    private ItemStatus mapRequestToItemStatus(final CreateItemStatusRequest request) {
        final ItemStatus itemStatus = new ItemStatus();
        itemStatus.setName(request.getName());
        return itemStatus;
    }

}
