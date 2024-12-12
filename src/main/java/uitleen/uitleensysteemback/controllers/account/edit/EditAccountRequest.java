package uitleen.uitleensysteemback.controllers.account.edit;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EditAccountRequest {
    private String firstname;
    private String insertion;
    private String lastname;
    private String email;
    private Long cardNumber;
    private Long groupId;
    private Long courseId;
//    private List<EditAccountRoleResponse> roles;
}
//
//@Getter
//@Setter
//class EditAccountRoleResponse {
//    private Long id;
//    private String name;
//}
