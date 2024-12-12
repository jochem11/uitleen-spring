package uitleen.uitleensysteemback.controllers.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uitleen.uitleensysteemback.controllers.account.create.CreateAccountRequest;
import uitleen.uitleensysteemback.controllers.account.create.CreateAccountService;
import uitleen.uitleensysteemback.controllers.account.deleteById.DeleteAccountService;
import uitleen.uitleensysteemback.controllers.account.edit.EditAccountRequest;
import uitleen.uitleensysteemback.controllers.account.edit.EditAccountService;
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
    private final EditAccountService editAccountService;
    private final CreateAccountService createAccountService;
    private final DeleteAccountService deleteAccountService;

    @Autowired
    public AccountController(GetAccountService getAccountService, GetByIdAccountService getByIdAccountService, EditAccountService editAccountService, CreateAccountService createAccountService, DeleteAccountService deleteAccountService) {
        this.getAccountService = getAccountService;
        this.getByIdAccountService = getByIdAccountService;
        this.editAccountService = editAccountService;
        this.createAccountService = createAccountService;
        this.deleteAccountService = deleteAccountService;
    }

    @GetMapping
    public List<GetAccountResponse> getAccounts() {
        return getAccountService.getAccounts();
    }

    @GetMapping("/{accountId}")
    public Optional<GetByIdAccountResponse> getAccountById(@PathVariable final long accountId) {
        return getByIdAccountService.getById(accountId);
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<HttpStatus> editAccount(@PathVariable final long accountId, @RequestBody final EditAccountRequest request) {
        editAccountService.editAccount(accountId, request);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createAccount(@RequestBody final CreateAccountRequest request) {
        createAccountService.createAccount(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<HttpStatus> deleteAccount(@PathVariable final long accountId) {
        deleteAccountService.deleteAccountById(accountId);
        return ResponseEntity.ok().build();
    }
}