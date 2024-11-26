package uitleen.uitleensysteemback.controllers.group;

import org.springframework.data.repository.CrudRepository;
import uitleen.uitleensysteemback.models.Group;

import java.util.List;

public interface GroupRepository extends CrudRepository<Group, Long> {
    List<Group> findAll();
}
