package uitleen.uitleensysteemback.controllers.account.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.account.AccountRepository;
import uitleen.uitleensysteemback.entities.Account;
import uitleen.uitleensysteemback.entities.Role;

@Service
public class EditAccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public EditAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void editAccount(final long accountId, final EditAccountRequest request) {
        final Account account = accountRepository.findById(accountId).orElseThrow(() -> new IllegalArgumentException("Item not found"));
        final Account updatedAccount = mapRequestToAccount(account, request);
        accountRepository.save(updatedAccount);
    }

    private Account mapRequestToAccount(Account account, final EditAccountRequest request) {
        account.setFirstname(request.getFirstname());
        account.setInsertion(request.getInsertion());
        account.setLastname(request.getLastname());
        account.setEmail(request.getEmail());
        account.setCardNumber(request.getCardNumber());
        account.setGroupId(request.getGroupId());
        account.setCourseId(request.getCourseId());
//        account.setRoles(account.getRoles().stream().map(this::mapRoles).toList());
        return account;
    }
//
//    private Role mapRoles(Role role) {
//        role.setId(role.getId());
//        role.setName(role.getName());
//        return role;
//    }
}
