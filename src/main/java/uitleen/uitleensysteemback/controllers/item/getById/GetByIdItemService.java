package uitleen.uitleensysteemback.controllers.item.getById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.item.ItemRepository;
import uitleen.uitleensysteemback.entities.Item;

import java.util.Optional;

@Service
public class GetByIdItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public GetByIdItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Optional<GetByIdItemResponse> getItemById(final long itemId) {
        Optional<Item> item = itemRepository.findById(itemId);
        return item.map(this::toItemResponse);
    }

    private GetByIdItemResponse toItemResponse(Item item) {
        GetByIdItemResponse response = new GetByIdItemResponse();
        response.setId(item.getId());
        response.setName(item.getName());
        response.setCategoryId(item.getCategory().getId());
        response.setItemStatusId(item.getItemStatus().getId());
        return response;
    }
}
