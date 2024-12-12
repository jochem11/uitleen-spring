package uitleen.uitleensysteemback.controllers.account.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.account.AccountRepository;
import uitleen.uitleensysteemback.entities.Account;

@Service
public class CreateAccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public CreateAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(final CreateAccountRequest request) {
        Account account = mapRequestToAccount(request);
        accountRepository.save(account);
    }

    private Account mapRequestToAccount(final CreateAccountRequest request) {
        Account account = new Account();
        account.setFirstname(request.getFirstname());
        account.setInsertion(request.getInsertion());
        account.setLastname(request.getLastname());
        account.setEmail(request.getEmail());
        account.setCardNumber(request.getCardNumber());
        account.setGroupId(request.getGroupId());
        account.setCourseId(request.getCourseId());
        return account;
    }
}
