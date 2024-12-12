package uitleen.uitleensysteemback.controllers.account.create;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAccountRequest {
    private String firstname;
    private String insertion;
    private String lastname;
    private String email;
    private Long cardNumber;
    private Long groupId;
    private Long courseId;
}
