package uitleen.uitleensysteemback.controllers.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uitleen.uitleensysteemback.controllers.item.create.CreateItemRequest;
import uitleen.uitleensysteemback.controllers.item.create.CreateItemService;
import uitleen.uitleensysteemback.controllers.item.deleteById.DeleteByIdItemService;
import uitleen.uitleensysteemback.controllers.item.edit.EditItemRequest;
import uitleen.uitleensysteemback.controllers.item.edit.EditItemService;
import uitleen.uitleensysteemback.controllers.item.get.GetItemResponse;
import uitleen.uitleensysteemback.controllers.item.get.GetItemService;
import uitleen.uitleensysteemback.controllers.item.getById.GetByIdItemResponse;
import uitleen.uitleensysteemback.controllers.item.getById.GetByIdItemService;
import uitleen.uitleensysteemback.controllers.item.paged.PagedItemResponse;
import uitleen.uitleensysteemback.controllers.item.paged.PagedItemService;
import uitleen.uitleensysteemback.entities.Item;
import uitleen.uitleensysteemback.models.PagedResponse;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final CreateItemService createItemService;
    private final GetItemService getItemService;
    private final GetByIdItemService getByIdItemService;
    private final DeleteByIdItemService deleteByIdItemService;
    private final EditItemService editItemService;
    private final PagedItemService pagedItemService;

    @Autowired
    public ItemController(CreateItemService createItemService,
                          GetItemService getItemService,
                          GetByIdItemService getByIdItemService,
                          DeleteByIdItemService deleteByIdItemService,
                          EditItemService editItemService, PagedItemService pagedItemService) {
        this.createItemService = createItemService;
        this.getItemService = getItemService;
        this.getByIdItemService = getByIdItemService;
        this.deleteByIdItemService = deleteByIdItemService;
        this.editItemService = editItemService;
        this.pagedItemService = pagedItemService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createItem(@RequestBody CreateItemRequest request) {
        createItemService.createItem(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<GetItemResponse> getItems(@RequestParam Optional<String> name,
                                          @RequestParam Optional<Long> categoryId,
                                          @RequestParam Optional<Long> itemStatusId) {
        return getItemService.getItems(name, categoryId, itemStatusId);
    }

    @GetMapping("/{itemId}")
    public Optional<GetByIdItemResponse> getItemById(@PathVariable long itemId) {
        return getByIdItemService.getItemById(itemId);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<HttpStatus> deleteItemById(@PathVariable long itemId) {
        deleteByIdItemService.deleteItemById(itemId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<HttpStatus> editItem(@PathVariable long itemId, @RequestBody EditItemRequest request) {
        editItemService.editItem(itemId, request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/paged")
    public PagedResponse<PagedItemResponse> getPagedItems(
            @RequestParam(defaultValue = "0") final int page,
            @RequestParam(defaultValue = "20") final int size,
            @RequestParam(defaultValue = "id") final String sortBy,
            @RequestParam(defaultValue = "asc") final String sortDir) {
        return pagedItemService.getPagedItems(page, size, sortBy, sortDir);
    }
}
