package uitleen.uitleensysteemback.controllers.account.get;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAccountResponse {
    private Long id;
    private String firstname;
    private String insertion;
    private String lastname;
    private String displayName;
    private String email;
    private Long cardNumber;
    private Long groupId;
    private Long courseId;
    private List<GetAccountRoleResponse> roles;
}

@Getter
@Setter
class GetAccountRoleResponse {
    private Long id;
    private String name;
}