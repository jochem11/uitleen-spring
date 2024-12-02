package uitleen.uitleensysteemback.controllers.group;

import org.springframework.data.jpa.repository.JpaRepository;
import uitleen.uitleensysteemback.entities.Group;


public interface GroupRepository extends JpaRepository<Group, Long> {
}
