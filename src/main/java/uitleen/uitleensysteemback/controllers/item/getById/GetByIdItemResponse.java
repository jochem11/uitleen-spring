package uitleen.uitleensysteemback.controllers.item.getById;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetByIdItemResponse {
    private Long id;
    private String name;
    private String description;
    private Long categoryId;
    private Long itemStatusId;
}
