package uitleen.uitleensysteemback.controllers.item.paged;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagedItemResponse {
    private Long id;
    private String name;
    private String description;
    private Long categoryId;
    private Long itemStatusId;
}
