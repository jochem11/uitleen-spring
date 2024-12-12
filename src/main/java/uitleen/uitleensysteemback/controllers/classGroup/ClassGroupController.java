package uitleen.uitleensysteemback.controllers.classGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uitleen.uitleensysteemback.controllers.classGroup.create.CreateClassGroupRequest;
import uitleen.uitleensysteemback.controllers.classGroup.create.CreateClassGroupService;
import uitleen.uitleensysteemback.controllers.classGroup.deleteById.DeleteByIdClassGroupService;
import uitleen.uitleensysteemback.controllers.classGroup.edit.EditClassGroupRequest;
import uitleen.uitleensysteemback.controllers.classGroup.edit.EditClassGroupService;
import uitleen.uitleensysteemback.controllers.classGroup.get.GetClassGroupResponse;
import uitleen.uitleensysteemback.controllers.classGroup.get.GetClassGroupService;
import uitleen.uitleensysteemback.controllers.classGroup.getById.GetByIdClassGroupResponse;
import uitleen.uitleensysteemback.controllers.classGroup.getById.GetByIdClassGroupService;
import uitleen.uitleensysteemback.controllers.classGroup.paged.PagedClassGroupResponse;
import uitleen.uitleensysteemback.controllers.classGroup.paged.PagedClassGroupService;
import uitleen.uitleensysteemback.models.PagedResponse;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/classgroups")
public class ClassGroupController {
    private final GetClassGroupService getClassGroupService;
    private final GetByIdClassGroupService getByIdClassGroupService;
    private final CreateClassGroupService createClassGroupService;
    private final EditClassGroupService editClassGroupService;
    private final DeleteByIdClassGroupService deleteByIdClassGroupService;
    private final PagedClassGroupService pagedClassGroupService;

    @Autowired
    public ClassGroupController(GetClassGroupService getClassGroupService, GetByIdClassGroupService getByIdClassGroupService, CreateClassGroupService createClassGroupService, EditClassGroupService editClassGroupService, DeleteByIdClassGroupService deleteByIdClassGroupService, PagedClassGroupService pagedClassGroupService) {
        this.getClassGroupService = getClassGroupService;
        this.getByIdClassGroupService = getByIdClassGroupService;
        this.createClassGroupService = createClassGroupService;
        this.editClassGroupService = editClassGroupService;
        this.deleteByIdClassGroupService = deleteByIdClassGroupService;
        this.pagedClassGroupService = pagedClassGroupService;
    }

    @GetMapping
    public List<GetClassGroupResponse> getGroups() {
        return getClassGroupService.getClassGroup();
    }

    @GetMapping("/{classGroupId}")
    public Optional<GetByIdClassGroupResponse> getGroupById(@PathVariable long classGroupId) {
        return getByIdClassGroupService.getClassGroupById(classGroupId);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createGroup(@RequestBody final CreateClassGroupRequest request) {
        createClassGroupService.createClassGroup(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{classGroupId}")
    public ResponseEntity<HttpStatus> editGroup(@PathVariable final long classGroupId, @RequestBody final EditClassGroupRequest request) {
        editClassGroupService.editClassGroup(classGroupId, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{classGroupId}")
    public ResponseEntity<HttpStatus> deleteGroupById(@PathVariable final long classGroupId) {
        deleteByIdClassGroupService.deleteClassGroupById(classGroupId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/paged")
    public PagedResponse<PagedClassGroupResponse> getPagedClassGroups(@RequestParam(defaultValue = "0") final int page, @RequestParam(defaultValue = "20") final int size) {
        return pagedClassGroupService.getPagedClassGroups(page, size);
    }
}
