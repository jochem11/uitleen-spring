package uitleen.uitleensysteemback.controllers.role.deleteById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.role.RoleRepository;

@Service
public class DeleteByIdRoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public DeleteByIdRoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void deleteByRoleId(final long id) {
        roleRepository.deleteById(id);
    }
}
