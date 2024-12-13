package uitleen.uitleensysteemback.controllers.itemStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uitleen.uitleensysteemback.controllers.itemStatus.create.CreateItemStatusRequest;
import uitleen.uitleensysteemback.controllers.itemStatus.create.CreateItemStatusService;
import uitleen.uitleensysteemback.controllers.itemStatus.deleteById.DeleteByIdItemStatusService;
import uitleen.uitleensysteemback.controllers.itemStatus.edit.EditItemStatusRequest;
import uitleen.uitleensysteemback.controllers.itemStatus.edit.EditItemStatusService;
import uitleen.uitleensysteemback.controllers.itemStatus.get.GetItemStatusResponse;
import uitleen.uitleensysteemback.controllers.itemStatus.get.GetItemStatusService;
import uitleen.uitleensysteemback.controllers.itemStatus.getById.GetByIdItemStatusResponse;
import uitleen.uitleensysteemback.controllers.itemStatus.getById.GetByIdItemStatusService;
import uitleen.uitleensysteemback.controllers.itemStatus.paged.PagedItemStatusResponse;
import uitleen.uitleensysteemback.controllers.itemStatus.paged.PagedItemStatusService;
import uitleen.uitleensysteemback.models.PagedResponse;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itemStatuses")
public class ItemStatusController {
    private final CreateItemStatusService createItemStatusService;
    private final GetItemStatusService getItemStatusService;
    private final DeleteByIdItemStatusService deleteByIdItemStatusService;
    private final GetByIdItemStatusService getByIdItemStatusService;
    private final EditItemStatusService editItemStatusService;
    private final PagedItemStatusService pagedItemStatusService;

    @Autowired
    public ItemStatusController(final CreateItemStatusService createItemStatusService,
                                final GetItemStatusService getItemStatusService,
                                final DeleteByIdItemStatusService deleteByIdItemStatusService,
                                final GetByIdItemStatusService getByIdItemStatusService,
                                final EditItemStatusService editItemStatusService, PagedItemStatusService pagedItemStatusService) {
        this.createItemStatusService = createItemStatusService;
        this.getItemStatusService = getItemStatusService;
        this.deleteByIdItemStatusService = deleteByIdItemStatusService;
        this.getByIdItemStatusService = getByIdItemStatusService;
        this.editItemStatusService = editItemStatusService;
        this.pagedItemStatusService = pagedItemStatusService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createItemStatus(@RequestBody final CreateItemStatusRequest request) {
        createItemStatusService.CreateItemStatus(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<GetItemStatusResponse> getItemStatuses() {
        return getItemStatusService.getCategories();
    }

    @DeleteMapping("/{itemStatusId}")
    public ResponseEntity<HttpStatus> deleteItemStatusById(@PathVariable final long itemStatusId) {
        deleteByIdItemStatusService.deleteById(itemStatusId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{itemStatusId}")
    public Optional<GetByIdItemStatusResponse> getItemStatusById(@PathVariable final long itemStatusId) {
        return getByIdItemStatusService.getById(itemStatusId);
    }

    @PutMapping("/{itemStatusId}")
    public ResponseEntity<HttpStatus> editItemStatus(@PathVariable final long itemStatusId, @RequestBody final EditItemStatusRequest request) {
        editItemStatusService.editItemStatus(itemStatusId, request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/paged")
    public PagedResponse<PagedItemStatusResponse> getPagedItemStatuses(
            @RequestParam(defaultValue = "0") final int page,
            @RequestParam(defaultValue = "20") final int size,
            @RequestParam(defaultValue = "id") final String sortBy,
            @RequestParam(defaultValue = "asc") final String sortDir) {
        return pagedItemStatusService.getPagedItemStatuses(page, size, sortBy, sortDir);
    }
}