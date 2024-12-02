package uitleen.uitleensysteemback.controllers.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uitleen.uitleensysteemback.controllers.account.get.GetAccountResponse;
import uitleen.uitleensysteemback.controllers.account.get.GetAccountService;
import uitleen.uitleensysteemback.controllers.account.getById.GetByIdAccountResponse;
import uitleen.uitleensysteemback.controllers.account.getById.GetByIdAccountService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final GetAccountService getAccountService;
    private final GetByIdAccountService getByIdAccountService;

    @Autowired
    public AccountController(GetAccountService getAccountService, GetByIdAccountService getByIdAccountService) {
        this.getAccountService = getAccountService;
        this.getByIdAccountService = getByIdAccountService;
    }

    @GetMapping
    public List<GetAccountResponse> getAccounts() {
        return getAccountService.getAccounts();
    }

    @GetMapping("/{accountId}")
    public Optional<GetByIdAccountResponse> getAccountById(@PathVariable final long accountId) {
        return getByIdAccountService.getById(accountId);
    }
}
