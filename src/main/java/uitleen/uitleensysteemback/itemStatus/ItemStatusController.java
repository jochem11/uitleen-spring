package uitleen.uitleensysteemback.itemStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uitleen.uitleensysteemback.itemStatus.create.CreateItemStatusRequest;
import uitleen.uitleensysteemback.itemStatus.create.CreateItemStatusService;
import uitleen.uitleensysteemback.itemStatus.deleteById.DeleteByIdItemStatusService;
import uitleen.uitleensysteemback.itemStatus.edit.EditItemStatusRequest;
import uitleen.uitleensysteemback.itemStatus.edit.EditItemStatusService;
import uitleen.uitleensysteemback.itemStatus.get.GetItemStatusService;
import uitleen.uitleensysteemback.itemStatus.getById.GetByIdItemStatusService;
import uitleen.uitleensysteemback.models.ItemStatus;

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

    @Autowired
    public ItemStatusController(final CreateItemStatusService createItemStatusService,
                                final GetItemStatusService getItemStatusService,
                                final DeleteByIdItemStatusService deleteByIdItemStatusService,
                                final GetByIdItemStatusService getByIdItemStatusService,
                                final EditItemStatusService editItemStatusService) {
        this.createItemStatusService = createItemStatusService;
        this.getItemStatusService = getItemStatusService;
        this.deleteByIdItemStatusService = deleteByIdItemStatusService;
        this.getByIdItemStatusService = getByIdItemStatusService;
        this.editItemStatusService = editItemStatusService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createItemStatus(@RequestBody final CreateItemStatusRequest request) {
        createItemStatusService.CreateItemStatus(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<ItemStatus> getItemStatuses() {
        return getItemStatusService.getCategories();
    }

    @DeleteMapping("/{itemStatusId}")
    public ResponseEntity<HttpStatus> deleteItemStatusById(@PathVariable final long itemStatusId) {
        deleteByIdItemStatusService.deleteById(itemStatusId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{itemStatusId}")
    public Optional<ItemStatus> getItemStatusById(@PathVariable final long itemStatusId) {
        return getByIdItemStatusService.getById(itemStatusId);
    }

    @PutMapping("/{itemStatusId}")
    public ResponseEntity<HttpStatus> editItemStatus(@PathVariable final long itemStatusId, @RequestBody final EditItemStatusRequest request) {
        editItemStatusService.editItemStatus(itemStatusId, request);
        return ResponseEntity.ok().build();
    }
}