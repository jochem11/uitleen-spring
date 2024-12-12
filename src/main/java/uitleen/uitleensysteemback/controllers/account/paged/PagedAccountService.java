package uitleen.uitleensysteemback.controllers.account.paged;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.account.AccountRepository;
import uitleen.uitleensysteemback.entities.Account;
import uitleen.uitleensysteemback.entities.Role;
import uitleen.uitleensysteemback.models.PagedResponse;

@Service
public class PagedAccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public PagedAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public PagedResponse<PagedAccountResponse> getPagedAccounts(final int page, final int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Account> accounts = accountRepository.findAll(pageRequest);
        Page<PagedAccountResponse> pagedAccountResponses = accounts.map(this::toPagedAccountResponse);

        return new PagedResponse<>(pagedAccountResponses);
    }

    private PagedAccountResponse toPagedAccountResponse(Account account) {
        PagedAccountResponse response = new PagedAccountResponse();
        response.setId(account.getId());
        response.setFirstname(account.getFirstname());
        response.setInsertion(account.getInsertion());
        response.setLastname(account.getLastname());
        response.setDisplayName(account.getDisplayName());
        response.setEmail(account.getEmail());
        response.setCardNumber(account.getCardNumber());
        response.setGroupId(account.getClassGroup().getId());
        response.setCourseId(account.getCourse().getId());
        response.setRoles(account.getRoles().stream().map(this::toRoleResponse).toList());
        return response;
    }

    private PagedAccountRoleResponse toRoleResponse(Role role) {
        PagedAccountRoleResponse response = new PagedAccountRoleResponse();
        response.setId(role.getId());
        response.setName(role.getName());
        return response;
    }
}
