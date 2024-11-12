package uitleen.uitleensysteemback.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uitleen.uitleensysteemback.item.create.CreateItemRequest;
import uitleen.uitleensysteemback.item.create.CreateItemService;
import uitleen.uitleensysteemback.item.deleteById.DeleteByIdItemService;
import uitleen.uitleensysteemback.item.edit.EditItemRequest;
import uitleen.uitleensysteemback.item.edit.EditItemService;
import uitleen.uitleensysteemback.item.get.GetItemService;
import uitleen.uitleensysteemback.item.getById.GetByIdItemService;
import uitleen.uitleensysteemback.models.Item;

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
    public List<Item> getItems(@RequestParam Optional<String> name,
                               @RequestParam Optional<String> categoryName,
                               @RequestParam Optional<String> itemStatusName) {
        return getItemService.getItems(name, categoryName, itemStatusName);
    }

    @GetMapping("/{itemId}")
    public Optional<Item> getItemById(@PathVariable long itemId) {
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
