package uitleen.uitleensysteemback.controllers.role.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.role.RoleRepository;
import uitleen.uitleensysteemback.entities.Role;

import java.util.List;

@Service
public class GetRoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public GetRoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<GetRoleResponse> getRoles() {
        return roleRepository.findAll().stream().map(this::mapRolesToResponse).toList();
    }

    private GetRoleResponse mapRolesToResponse(final Role role) {
        GetRoleResponse response = new GetRoleResponse();
        response.setId(role.getId());
        response.setName(role.getName());
        return response;
    }
}
