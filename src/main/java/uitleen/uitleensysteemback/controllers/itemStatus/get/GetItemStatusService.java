package uitleen.uitleensysteemback.controllers.itemStatus.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.itemStatus.ItemStatusRepository;
import uitleen.uitleensysteemback.models.ItemStatus;

import java.util.List;

@Service
public class GetItemStatusService {
    private final ItemStatusRepository itemStatusRepository;

    @Autowired
    public GetItemStatusService(final ItemStatusRepository itemStatusRepository) {
        this.itemStatusRepository = itemStatusRepository;
    }

    public List<ItemStatus> getCategories() {
        return itemStatusRepository.findAll();
    }
}