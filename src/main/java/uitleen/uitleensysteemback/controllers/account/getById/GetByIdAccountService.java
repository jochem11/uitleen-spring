package uitleen.uitleensysteemback.controllers.account.getById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.account.AccountRepository;
import uitleen.uitleensysteemback.entities.Account;
import uitleen.uitleensysteemback.entities.Role;

import java.util.Optional;

@Service
public class GetByIdAccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public GetByIdAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Optional<GetByIdAccountResponse> getById(long accountId) {
        return accountRepository.findById(accountId).map(this::toAccountResponse);
    }

    private GetByIdAccountResponse toAccountResponse(Account account) {
        GetByIdAccountResponse response = new GetByIdAccountResponse();
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

    private GetByIdAccountRoleResponse toRoleResponse(Role accountRole) {
        GetByIdAccountRoleResponse response = new GetByIdAccountRoleResponse();
        response.setId(accountRole.getId());
        response.setName(accountRole.getName());
        return response;
    }
}
