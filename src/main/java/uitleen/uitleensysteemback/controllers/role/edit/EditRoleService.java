package uitleen.uitleensysteemback.controllers.role.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.role.RoleRepository;
import uitleen.uitleensysteemback.entities.Role;

@Service
public class EditRoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public EditRoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void editRole(final long id, final EditRoleRequest request) {
        final Role role = roleRepository.findById(id).orElseThrow();
        roleRepository.save(mapRequestToRole(role, request));
    }

    private Role mapRequestToRole(final Role role, final EditRoleRequest request) {
        role.setName(request.getName());
        return role;
    }
}
