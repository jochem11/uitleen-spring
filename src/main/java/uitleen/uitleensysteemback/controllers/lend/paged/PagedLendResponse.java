package uitleen.uitleensysteemback.controllers.lend.paged;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PagedLendResponse {
    private Long id;
    private Long accountId;
    private Long itemId;
    private LocalDateTime lendDate;
    private LocalDateTime returnDate;
}
