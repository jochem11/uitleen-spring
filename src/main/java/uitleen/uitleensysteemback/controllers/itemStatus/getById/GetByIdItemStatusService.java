package uitleen.uitleensysteemback.controllers.itemStatus.getById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.itemStatus.ItemStatusRepository;
import uitleen.uitleensysteemback.entities.ItemStatus;

import java.util.Optional;

@Service
public class GetByIdItemStatusService {
    private final ItemStatusRepository itemStatusRepository;

    @Autowired
    public GetByIdItemStatusService(final ItemStatusRepository itemStatusRepository) {
        this.itemStatusRepository = itemStatusRepository;
    }

    public Optional<GetByIdItemStatusResponse> getById(final long itemStatusId) {
        Optional<ItemStatus> itemStatus = itemStatusRepository.findById(itemStatusId);
        return itemStatus.map(this::toItemStatusResponse);
    }

    private GetByIdItemStatusResponse toItemStatusResponse(ItemStatus itemStatus) {
        GetByIdItemStatusResponse response = new GetByIdItemStatusResponse();
        response.setId(itemStatus.getId());
        response.setName(itemStatus.getName());
        return response;
    }
}
