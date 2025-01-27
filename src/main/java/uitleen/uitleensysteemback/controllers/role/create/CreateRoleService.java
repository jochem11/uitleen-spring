package uitleen.uitleensysteemback.controllers.role.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.role.RoleRepository;
import uitleen.uitleensysteemback.entities.Role;

@Service
public class CreateRoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public CreateRoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void createRole(CreateRoleRequest request) {
        roleRepository.save(mapRequestToRole(request));
    }

    private Role mapRequestToRole(CreateRoleRequest request) {
        final Role role = new Role();
        role.setName(request.getName());
        return role;
    }
}
