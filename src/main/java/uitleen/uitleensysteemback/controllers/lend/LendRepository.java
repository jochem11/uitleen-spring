package uitleen.uitleensysteemback.controllers.lend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uitleen.uitleensysteemback.entities.Lend;

@Repository
public interface LendRepository extends JpaRepository<Lend, Long> {
}
