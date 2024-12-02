package uitleen.uitleensysteemback.controllers.itemStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import uitleen.uitleensysteemback.entities.ItemStatus;

public interface ItemStatusRepository extends JpaRepository<ItemStatus, Long> {
}
