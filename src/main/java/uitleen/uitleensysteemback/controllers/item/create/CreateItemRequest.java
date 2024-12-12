package uitleen.uitleensysteemback.controllers.item.create;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateItemRequest {
    private String name;
    private String description;
    private long categoryId;
    private long itemStatusId;
}