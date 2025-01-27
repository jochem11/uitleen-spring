package uitleen.uitleensysteemback.controllers.lend.paged;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.lend.LendRepository;
import uitleen.uitleensysteemback.entities.Lend;
import uitleen.uitleensysteemback.models.PagedResponse;
import uitleen.uitleensysteemback.utils.SortUtils;

@Service
public class PagedLendService {
    private final LendRepository lendRepository;

    @Autowired
    public PagedLendService(LendRepository lendRepository) {
        this.lendRepository = lendRepository;
    }

    public PagedResponse<PagedLendResponse> getPagedLends(final int page, final int size, final String sortBy, final String sortDir) {
        PageRequest pageRequest = PageRequest.of(page, size, SortUtils.getPagedSort(PagedLendResponse.class, sortBy, sortDir));
        Page<Lend> lends = lendRepository.findAll(pageRequest);
        Page<PagedLendResponse> pagedLendResponses = lends.map(this::toPagedLendResponse);
        return new PagedResponse<>(pagedLendResponses);
    }

    private PagedLendResponse toPagedLendResponse(Lend lend) {
        PagedLendResponse response = new PagedLendResponse();
        response.setId(lend.getId());
        response.setAccountId(lend.getAccountId());
        response.setItemId(lend.getItemId());
        response.setLendDate(lend.getLendDate());
        return response;
    }
}
