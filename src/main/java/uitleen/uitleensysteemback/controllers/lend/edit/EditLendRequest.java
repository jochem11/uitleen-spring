package uitleen.uitleensysteemback.controllers.lend.edit;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EditLendRequest {
    private Long accountId;
    private Long itemId;
    private LocalDateTime lendDate;
    private LocalDateTime returnDate;
}
