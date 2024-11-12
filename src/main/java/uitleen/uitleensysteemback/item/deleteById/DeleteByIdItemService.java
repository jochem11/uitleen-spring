package uitleen.uitleensysteemback.item.deleteById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.item.ItemRepository;

@Service
public class DeleteByIdItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public DeleteByIdItemService(final ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void deleteItemById(final long itemId) {
        itemRepository.deleteById(itemId);
    }
}