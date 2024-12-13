package uitleen.uitleensysteemback.controllers.item.paged;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.item.ItemRepository;
import uitleen.uitleensysteemback.entities.Item;
import uitleen.uitleensysteemback.models.PagedResponse;
import uitleen.uitleensysteemback.utils.SortUtils;

@Service
public class PagedItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public PagedItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public PagedResponse<PagedItemResponse> getPagedItems(final int page, final int size, final String sortBy, final String sortDir) {
        Sort sort = SortUtils.getPagedSort(PagedItemResponse.class ,sortBy, sortDir);

        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Item> items = itemRepository.findAll(pageRequest);
        Page<PagedItemResponse> pagedItemResponses = items.map(this::toPagedItemResponse);

        return new PagedResponse<>(pagedItemResponses);
    }

    private PagedItemResponse toPagedItemResponse(Item item) {
        PagedItemResponse response = new PagedItemResponse();
        response.setId(item.getId());
        response.setName(item.getName());
        response.setDescription(item.getDescription());
        response.setCategoryId(item.getCategoryId());
        response.setItemStatusId(item.getItemStatusId());
        return response;
    }
}
