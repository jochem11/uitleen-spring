package uitleen.uitleensysteemback.controllers.item.get;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetItemResponse {
    private Long id;
    private String name;
    private String description;
    private Long categoryId;
    private Long itemStatusId;
}
