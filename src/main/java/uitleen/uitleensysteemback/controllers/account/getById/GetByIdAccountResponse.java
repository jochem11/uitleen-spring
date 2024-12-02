package uitleen.uitleensysteemback.controllers.account.getById;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetByIdAccountResponse {
    private Long id;
    private String firstname;
    private String insertion;
    private String lastname;
    private String displayName;
    private String email;
    private Long cardNumber;
    private Long groupId;
    private Long courseId;
    private List<GetByIdAccountRoleResponse> roles;
}

@Getter
@Setter
class GetByIdAccountRoleResponse {
    private Long id;
    private String name;
}