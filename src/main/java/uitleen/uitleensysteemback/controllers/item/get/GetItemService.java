package uitleen.uitleensysteemback.controllers.item.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.item.ItemRepository;
import uitleen.uitleensysteemback.models.Item;

import java.util.List;
import java.util.Optional;

@Service
public class GetItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public GetItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getItems(final Optional<String> name, final Optional<String> categoryName , final Optional<String> itemStatusName) {

        if (name.isPresent() || categoryName.isPresent() || itemStatusName.isPresent()) {
            return itemRepository.findByFilters(name, categoryName, itemStatusName);
        }

        return itemRepository.findAll();
    }
}
