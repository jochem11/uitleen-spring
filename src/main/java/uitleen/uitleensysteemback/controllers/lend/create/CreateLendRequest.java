package uitleen.uitleensysteemback.controllers.lend.create;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateLendRequest {
    private Long accountId;
    private Long itemId;
}
