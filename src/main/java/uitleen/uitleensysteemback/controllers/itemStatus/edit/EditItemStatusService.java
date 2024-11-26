package uitleen.uitleensysteemback.controllers.itemStatus.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.itemStatus.ItemStatusRepository;
import uitleen.uitleensysteemback.models.ItemStatus;

@Service
public class EditItemStatusService {
    private final ItemStatusRepository itemStatusRepository;

    @Autowired
    public EditItemStatusService(final ItemStatusRepository itemStatusRepository) {
        this.itemStatusRepository = itemStatusRepository;
    }

    public void editItemStatus(final long itemStatusId, final EditItemStatusRequest request) {
        final ItemStatus itemstatus = itemStatusRepository.findById(itemStatusId).orElseThrow(() -> new RuntimeException("ItemStatus not found"));
        final ItemStatus newItemStatus = mapRequestToItemStatus(itemstatus, request);
        itemStatusRepository.save(newItemStatus);
    }

    private ItemStatus mapRequestToItemStatus(ItemStatus itemstatus, EditItemStatusRequest request) {
        itemstatus.setName(request.getName());
        return itemstatus;
    }
}
