package uitleen.uitleensysteemback.controllers.item.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.item.ItemRepository;
import uitleen.uitleensysteemback.models.Item;

@Service
public class CreateItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public CreateItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void createItem(CreateItemRequest request) {
        itemRepository.save(mapRequestToItem(request));
    }

    private Item mapRequestToItem(final CreateItemRequest request) {
        final Item item = new Item();
        item.setName(request.getName());
        item.setDescription(request.getDescription());
        item.setCategory(request.getCategory());
        item.setItemStatus(request.getItemStatus());
        return item;
    }
}
