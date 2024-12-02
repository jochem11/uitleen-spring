package uitleen.uitleensysteemback.controllers.account.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.account.AccountRepository;
import uitleen.uitleensysteemback.entities.Account;
import uitleen.uitleensysteemback.entities.Role;

import java.util.List;

@Service
public class GetAccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public GetAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<GetAccountResponse> getAccounts() {
        return accountRepository.findAll().stream()
                .map(this::toAccountResponse)
                .toList();
    }

    private GetAccountResponse toAccountResponse(Account account) {
        GetAccountResponse response = new GetAccountResponse();
        response.setId(account.getId());
        response.setFirstname(account.getFirstname());
        response.setInsertion(account.getInsertion());
        response.setLastname(account.getLastname());
        response.setDisplayName(account.getDisplayName());
        response.setEmail(account.getEmail());
        response.setCardNumber(account.getCardNumber());
        response.setGroupId(account.getGroup().getId());
        response.setCourseId(account.getCourse().getId());
        response.setRoles(account.getRoles().stream().map(this::toRoleResponse).toList());
        return response;
    }

    private GetAccountRoleResponse toRoleResponse(Role role) {
        GetAccountRoleResponse response = new GetAccountRoleResponse();
        response.setId(role.getId());
        response.setName(role.getName());
        return response;
    }
}
