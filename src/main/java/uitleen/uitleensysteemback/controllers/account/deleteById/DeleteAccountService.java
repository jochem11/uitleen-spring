package uitleen.uitleensysteemback.controllers.account.deleteById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.account.AccountRepository;

@Service
public class DeleteAccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public DeleteAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void deleteAccountById(final long accountId) {
        accountRepository.deleteById(accountId);
    }
}
