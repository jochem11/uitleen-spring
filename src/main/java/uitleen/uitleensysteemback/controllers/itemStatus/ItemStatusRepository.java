package uitleen.uitleensysteemback.controllers.itemStatus;

import org.springframework.data.repository.CrudRepository;
import uitleen.uitleensysteemback.models.ItemStatus;

import java.util.List;

public interface ItemStatusRepository extends CrudRepository<ItemStatus, Long> {
    List<ItemStatus> findAll();
}
