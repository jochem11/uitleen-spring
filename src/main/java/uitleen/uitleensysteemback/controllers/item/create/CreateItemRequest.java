package uitleen.uitleensysteemback.controllers.item.create;

import lombok.Getter;
import lombok.Setter;
import uitleen.uitleensysteemback.entities.Category;
import uitleen.uitleensysteemback.entities.ItemStatus;

@Getter
@Setter
public class CreateItemRequest {
    private String name;

    private String description;

    private Category category;

    private ItemStatus itemStatus;
}
