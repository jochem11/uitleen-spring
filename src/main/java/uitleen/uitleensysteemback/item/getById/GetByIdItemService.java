package uitleen.uitleensysteemback.item.getById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.item.ItemRepository;
import uitleen.uitleensysteemback.models.Item;

import java.util.Optional;

@Service
public class GetByIdItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public GetByIdItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Optional<Item> getItemById(final long itemId) {
        return itemRepository.findById(itemId);
    }
}
