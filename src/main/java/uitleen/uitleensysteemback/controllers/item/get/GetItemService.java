package uitleen.uitleensysteemback.controllers.item.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.item.ItemRepository;
import uitleen.uitleensysteemback.entities.Item;

import java.util.List;
import java.util.Optional;

@Service
public class GetItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public GetItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<GetItemResponse> getItems(final Optional<String> name, final Optional<String> categoryName , final Optional<String> itemStatusName) {

        if (name.isPresent() || categoryName.isPresent() || itemStatusName.isPresent()) {
            List<Item> items = itemRepository.findByFilters(name, categoryName, itemStatusName);
            return items.stream()
                    .map(this::toItemResponse)
                    .toList();
        }

        List<Item> items =  itemRepository.findAll();
        return items.stream()
                .map(this::toItemResponse)
                .toList();
    }

    private GetItemResponse toItemResponse(Item item) {
        GetItemResponse response = new GetItemResponse();
        response.setId(item.getId());
        response.setName(item.getName());
        response.setCategoryId(item.getCategory().getId());
        response.setItemStatusId(item.getItemStatus().getId());
        return response;
    }
}
