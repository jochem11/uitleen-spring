package uitleen.uitleensysteemback.controllers.item.edit;

import lombok.Getter;
import lombok.Setter;
import uitleen.uitleensysteemback.entities.Category;
import uitleen.uitleensysteemback.entities.ItemStatus;

@Getter
@Setter
public class EditItemRequest {
    private String name;

    private String description;

    private long categoryId;

    private long itemStatusId;
}
