package uitleen.uitleensysteemback.controllers.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uitleen.uitleensysteemback.controllers.role.create.CreateRoleRequest;
import uitleen.uitleensysteemback.controllers.role.create.CreateRoleService;
import uitleen.uitleensysteemback.controllers.role.deleteById.DeleteByIdRoleService;
import uitleen.uitleensysteemback.controllers.role.edit.EditRoleRequest;
import uitleen.uitleensysteemback.controllers.role.edit.EditRoleService;
import uitleen.uitleensysteemback.controllers.role.get.GetRoleResponse;
import uitleen.uitleensysteemback.controllers.role.get.GetRoleService;
import uitleen.uitleensysteemback.controllers.role.getById.GetByIdRoleResponse;
import uitleen.uitleensysteemback.controllers.role.getById.GetByIdRoleService;
import uitleen.uitleensysteemback.controllers.role.paged.PagedRoleResponse;
import uitleen.uitleensysteemback.controllers.role.paged.PagedRoleService;
import uitleen.uitleensysteemback.entities.Role;
import uitleen.uitleensysteemback.models.PagedResponse;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private final CreateRoleService createRoleService;
    private final DeleteByIdRoleService deleteByIdRoleService;
    private final EditRoleService editRoleService;
    private final GetByIdRoleService getByIdRoleService;
    private final GetRoleService getRoleService;
    private final PagedRoleService pagedRoleService;

    @Autowired
    public RoleController(CreateRoleService createRoleService, DeleteByIdRoleService deleteByIdRoleService, EditRoleService editRoleService, GetByIdRoleService getByIdRoleService, GetRoleService getRoleService, PagedRoleService pagedRoleService) {
        this.createRoleService = createRoleService;
        this.deleteByIdRoleService = deleteByIdRoleService;
        this.editRoleService = editRoleService;
        this.getByIdRoleService = getByIdRoleService;
        this.getRoleService = getRoleService;
        this.pagedRoleService = pagedRoleService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createRole(CreateRoleRequest request) {
        createRoleService.createRole(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity<HttpStatus> deleteByRoleId(@PathVariable final long roleId) {
        deleteByIdRoleService.deleteByRoleId(roleId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{roleId}")
    public ResponseEntity<HttpStatus> editRole(@PathVariable final long roleId, @RequestBody final EditRoleRequest request) {
        editRoleService.editRole(roleId, request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{roleId}")
    public Optional<GetByIdRoleResponse> getByIdRole(@PathVariable final long roleId) {
        return getByIdRoleService.getById(roleId);
    }

    @GetMapping
    public List<GetRoleResponse> getRoles() {
        return getRoleService.getRoles();
    }

    @GetMapping("/paged")
    public PagedResponse<PagedRoleResponse> getPagedRoles(
        @RequestParam(defaultValue = "0") final int page,
        @RequestParam(defaultValue = "20") final int size,
        @RequestParam(defaultValue = "id") final String sortBy,
        @RequestParam(defaultValue = "asc") final String sortDir) {
            return pagedRoleService.getPagedRoles(page, size, sortBy, sortDir);
    }
}
