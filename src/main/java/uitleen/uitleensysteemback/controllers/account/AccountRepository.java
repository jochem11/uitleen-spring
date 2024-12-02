package uitleen.uitleensysteemback.controllers.account;

import org.springframework.data.jpa.repository.JpaRepository;
import uitleen.uitleensysteemback.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
