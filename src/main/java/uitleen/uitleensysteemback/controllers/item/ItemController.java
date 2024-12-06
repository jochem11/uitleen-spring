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
import uitleen.uitleensysteemback.entities.Item;

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

    @Autowired
    public ItemController(CreateItemService createItemService,
                          GetItemService getItemService,
                          GetByIdItemService getByIdItemService,
                          DeleteByIdItemService deleteByIdItemService,
                          EditItemService editItemService) {
        this.createItemService = createItemService;
        this.getItemService = getItemService;
        this.getByIdItemService = getByIdItemService;
        this.deleteByIdItemService = deleteByIdItemService;
        this.editItemService = editItemService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createItem(@RequestBody CreateItemRequest request) {
        createItemService.createItem(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<GetItemResponse> getItems(@RequestParam Optional<String> name,
                                          @RequestParam Optional<String> categoryName,
                                          @RequestParam Optional<String> itemStatusName) {
        return getItemService.getItems(name, categoryName, itemStatusName);
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
}
