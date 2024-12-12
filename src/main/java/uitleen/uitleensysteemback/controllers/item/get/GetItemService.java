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

    public List<GetItemResponse> getItems(final Optional<String> name, final Optional<Long> categoryId, final Optional<Long> itemStatusId) {
        if (name.isPresent() || categoryId.isPresent() || itemStatusId.isPresent()) {
            List<Item> items = itemRepository.findByFilters(
                    name.orElse(null),
                    categoryId.orElse(null),
                    itemStatusId.orElse(null)
            );
            return items.stream()
                    .map(this::toItemResponse)
                    .toList();
        }

        List<Item> items = itemRepository.findAll();

        return items.stream()
                .map(this::toItemResponse)
                .toList();
    }

    private GetItemResponse toItemResponse(Item item) {
        GetItemResponse response = new GetItemResponse();
        response.setId(item.getId());
        response.setName(item.getName());
        response.setCategoryId(item.getCategoryId());
        response.setItemStatusId(item.getItemStatusId());
        return response;
    }
}