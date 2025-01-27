package uitleen.uitleensysteemback.controllers.role.paged;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.role.RoleRepository;
import uitleen.uitleensysteemback.entities.Role;
import uitleen.uitleensysteemback.models.PagedResponse;
import uitleen.uitleensysteemback.utils.SortUtils;

@Service
public class PagedRoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public PagedRoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public PagedResponse<PagedRoleResponse> getPagedRoles(final int page, final int size, final String sortBy, final String sortDir) {
        Sort sort = SortUtils.getPagedSort(PagedRoleResponse.class, sortBy, sortDir);

        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return new PagedResponse<>(roleRepository.findAll(pageRequest).map(this::toPagedRoleResponse));
    }

    private PagedRoleResponse toPagedRoleResponse(Role role) {
        final PagedRoleResponse response = new PagedRoleResponse();
        response.setId(role.getId());
        response.setName(role.getName());
        return response;
    }
}
