package uitleen.uitleensysteemback.items;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import uitleen.uitleensysteemback.controllers.item.ItemRepository;
import uitleen.uitleensysteemback.controllers.item.create.CreateItemRequest;
import uitleen.uitleensysteemback.controllers.item.create.CreateItemService;
import uitleen.uitleensysteemback.controllers.item.edit.EditItemRequest;
import uitleen.uitleensysteemback.controllers.item.edit.EditItemService;
import uitleen.uitleensysteemback.entities.Item;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemsTests {

    @Mock
    private ItemRepository itemsRepository;

    @InjectMocks
    private CreateItemService createItemService;

    @InjectMocks
    private EditItemService editItemService;

    @Test
    public void testCreateItem() {
        CreateItemRequest mockRequest = new CreateItemRequest();
        mockRequest.setName("Test");
        mockRequest.setDescription("TestDescription");
        mockRequest.setCategoryId(1);
        mockRequest.setItemStatusId(1);

        ArgumentCaptor<Item> itemCaptor = ArgumentCaptor.forClass(Item.class);

        when(itemsRepository.save(Mockito.any(Item.class))).thenAnswer(i -> i.getArgument(0));

        createItemService.createItem(mockRequest);

        Mockito.verify(itemsRepository).save(itemCaptor.capture());

        Item capturedItem = itemCaptor.getValue();
        assertEquals(mockRequest.getName(), capturedItem.getName());
        assertEquals(mockRequest.getDescription(), capturedItem.getDescription());
        assertEquals(mockRequest.getCategoryId(), capturedItem.getCategoryId());
        assertEquals(mockRequest.getItemStatusId(), capturedItem.getItemStatusId());
    }

    @Test
    public void testEditItem() {
        long itemId = 1;
        EditItemRequest mockRequest = new EditItemRequest();
        mockRequest.setName("UpdatedTest");
        mockRequest.setDescription("UpdatedDescription");
        mockRequest.setCategoryId(2);
        mockRequest.setItemStatusId(2);

        Item existingItem = new Item();
        existingItem.setId(itemId);
        existingItem.setName("OldTest");
        existingItem.setDescription("OldDescription");
        existingItem.setCategoryId(1);
        existingItem.setItemStatusId(1);

        when(itemsRepository.findById(itemId)).thenReturn(Optional.of(existingItem));
        when(itemsRepository.save(Mockito.any(Item.class))).thenAnswer(i -> i.getArgument(0));

        editItemService.editItem(itemId, mockRequest);

        Mockito.verify(itemsRepository).findById(itemId);
        Mockito.verify(itemsRepository).save(Mockito.any(Item.class));

        ArgumentCaptor<Item> itemCaptor = ArgumentCaptor.forClass(Item.class);
        Mockito.verify(itemsRepository).save(itemCaptor.capture());

        Item capturedItem = itemCaptor.getValue();
        assertEquals(mockRequest.getName(), capturedItem.getName());
        assertEquals(mockRequest.getDescription(), capturedItem.getDescription());
        assertEquals(mockRequest.getCategoryId(), capturedItem.getCategoryId());
        assertEquals(mockRequest.getItemStatusId(), capturedItem.getItemStatusId());
    }

}
