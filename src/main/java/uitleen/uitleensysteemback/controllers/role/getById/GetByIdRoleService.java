package uitleen.uitleensysteemback.controllers.role.getById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.role.RoleRepository;
import uitleen.uitleensysteemback.entities.Role;

import java.util.Optional;

@Service
public class GetByIdRoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public GetByIdRoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Optional<GetByIdRoleResponse> getById(final long id) {
        return roleRepository.findById(id).stream().map(this::mapRoleToResponse).findFirst();
    }

    public GetByIdRoleResponse mapRoleToResponse(final Role role) {
        GetByIdRoleResponse response = new GetByIdRoleResponse();
        response.setId(role.getId());
        response.setName(role.getName());
        return response;
    }
}
