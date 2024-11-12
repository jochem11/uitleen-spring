package uitleen.uitleensysteemback.item.edit;

import lombok.Getter;
import lombok.Setter;
import uitleen.uitleensysteemback.models.Category;
import uitleen.uitleensysteemback.models.ItemStatus;

@Getter
@Setter
public class EditItemRequest {
    private String name;

    private String description;

    private Category category;

    private ItemStatus itemStatus;
}
