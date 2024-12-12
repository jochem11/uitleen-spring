package uitleen.uitleensysteemback.controllers.item.create;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.item.ItemRepository;
import uitleen.uitleensysteemback.entities.Item;

@Service
@Transactional
public class CreateItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public CreateItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void createItem(CreateItemRequest request) {
        Item item = new Item();
        item.setName(request.getName());
        item.setDescription(request.getDescription());
        item.setCategoryId(request.getCategoryId());
        item.setItemStatusId(request.getItemStatusId());

        itemRepository.save(item);
    }
}
