package uitleen.uitleensysteemback.controllers.item.create;

import lombok.Getter;
import lombok.Setter;
import uitleen.uitleensysteemback.models.Category;
import uitleen.uitleensysteemback.models.ItemStatus;

@Getter
@Setter
public class CreateItemRequest {
    private String name;

    private String description;

    private Category category;

    private ItemStatus itemStatus;
}
