package uitleen.uitleensysteemback.controllers.itemStatus.paged;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.itemStatus.ItemStatusRepository;
import uitleen.uitleensysteemback.entities.ItemStatus;
import uitleen.uitleensysteemback.models.PagedResponse;
import uitleen.uitleensysteemback.utils.SortUtils;

@Service
public class PagedItemStatusService {
    private final ItemStatusRepository itemStatusRepository;

    @Autowired
    public PagedItemStatusService(ItemStatusRepository itemStatusRepository) {
        this.itemStatusRepository = itemStatusRepository;
    }

    public PagedResponse<PagedItemStatusResponse> getPagedItemStatuses(final int page, final int size, final String sortBy, final String sortDir) {
        Sort sort = SortUtils.getPagedSort(PagedItemStatusResponse.class, sortBy, sortDir);

        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<ItemStatus> pageResult = itemStatusRepository.findAll(pageRequest);
        Page<PagedItemStatusResponse> responsePage = pageResult.map(this::toPagedItemStatusResponse);

        return new PagedResponse<>(responsePage);
    }

    private PagedItemStatusResponse toPagedItemStatusResponse(ItemStatus itemStatus) {
        PagedItemStatusResponse response = new PagedItemStatusResponse();
        response.setId(itemStatus.getId());
        response.setName(itemStatus.getName());
        return response;
    }
}
