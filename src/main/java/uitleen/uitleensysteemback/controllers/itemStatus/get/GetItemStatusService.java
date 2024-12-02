package uitleen.uitleensysteemback.controllers.itemStatus.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.itemStatus.ItemStatusRepository;
import uitleen.uitleensysteemback.entities.ItemStatus;

import java.util.List;

@Service
public class GetItemStatusService {
    private final ItemStatusRepository itemStatusRepository;

    @Autowired
    public GetItemStatusService(final ItemStatusRepository itemStatusRepository) {
        this.itemStatusRepository = itemStatusRepository;
    }

    public List<GetItemStatusResponse> getCategories() {
        List<ItemStatus> itemStatuses = itemStatusRepository.findAll();

        return itemStatuses.stream()
                .map(this::toItemStatusResponse)
                .toList();
    }

    private GetItemStatusResponse toItemStatusResponse(ItemStatus itemStatus) {
        GetItemStatusResponse response = new GetItemStatusResponse();
        response.setId(itemStatus.getId());
        response.setName(itemStatus.getName());
        return response;
    }
}