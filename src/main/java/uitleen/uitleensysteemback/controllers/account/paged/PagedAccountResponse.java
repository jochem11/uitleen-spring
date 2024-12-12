package uitleen.uitleensysteemback.controllers.account.paged;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PagedAccountResponse {
    private Long id;
    private String firstname;
    private String insertion;
    private String lastname;
    private String displayName;
    private String email;
    private Long cardNumber;
    private Long groupId;
    private Long courseId;
    private List<PagedAccountRoleResponse> roles;
}

@Getter
@Setter
class PagedAccountRoleResponse {
    private Long id;
    private String name;
}