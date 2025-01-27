package uitleen.uitleensysteemback.controllers.role;

import org.springframework.data.jpa.repository.JpaRepository;
import uitleen.uitleensysteemback.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
