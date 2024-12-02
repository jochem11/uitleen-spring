package uitleen.uitleensysteemback.controllers.item.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.item.ItemRepository;
import uitleen.uitleensysteemback.entities.Item;

@Service
public class EditItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public EditItemService(final ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void editItem(final long itemId, final EditItemRequest request) {
        final Item item = itemRepository.findById(itemId).orElseThrow(() -> new IllegalArgumentException("Item not found"));
        final Item updatedItem = mapRequestToItem(item, request);
        itemRepository.save(updatedItem);
    }

    private Item mapRequestToItem(Item item, final EditItemRequest request) {
        item.setName(request.getName());
        item.setDescription(request.getDescription());
        item.setCategory(request.getCategory());
        item.setItemStatus(request.getItemStatus());
        return item;
    }
}
