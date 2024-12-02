package uitleen.uitleensysteemback.controllers.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uitleen.uitleensysteemback.controllers.group.create.CreateGroupRequest;
import uitleen.uitleensysteemback.controllers.group.create.CreateGroupService;
import uitleen.uitleensysteemback.controllers.group.deleteById.DeleteByIdGroupService;
import uitleen.uitleensysteemback.controllers.group.edit.EditGroupRequest;
import uitleen.uitleensysteemback.controllers.group.edit.EditGroupService;
import uitleen.uitleensysteemback.controllers.group.get.GetGroupResponse;
import uitleen.uitleensysteemback.controllers.group.get.GetGroupService;
import uitleen.uitleensysteemback.controllers.group.getById.GetByIdGroupResponse;
import uitleen.uitleensysteemback.controllers.group.getById.GetByIdGroupService;
import uitleen.uitleensysteemback.entities.Group;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GetGroupService getGroupService;
    private final GetByIdGroupService getByIdGroupService;
    private final CreateGroupService createGroupService;
    private final EditGroupService editGroupService;
    private final DeleteByIdGroupService deleteByIdGroupService;

    @Autowired
    public GroupController(GetGroupService getGroupService, GetByIdGroupService getByIdGroupService, CreateGroupService createGroupService, EditGroupService editGroupService, DeleteByIdGroupService deleteByIdGroupService) {
        this.getGroupService = getGroupService;
        this.getByIdGroupService = getByIdGroupService;
        this.createGroupService = createGroupService;
        this.editGroupService = editGroupService;
        this.deleteByIdGroupService = deleteByIdGroupService;
    }

    @GetMapping
    public List<GetGroupResponse> getGroups() {
        return getGroupService.getGroups();
    }

    @GetMapping("/{groupId}")
    public Optional<GetByIdGroupResponse> getGroupById(@PathVariable long groupId) {
        return getByIdGroupService.getGroupById(groupId);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createGroup(@RequestBody final CreateGroupRequest request) {
        createGroupService.createGroup(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{groupId}")
    public ResponseEntity<HttpStatus> editGroup(@PathVariable final long groupId, @RequestBody final EditGroupRequest request) {
        editGroupService.editGroup(groupId, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{groupId}")
    public ResponseEntity<HttpStatus> deleteGroupById(@PathVariable final long groupId) {
        deleteByIdGroupService.deleteGroupById(groupId);
        return ResponseEntity.ok().build();
    }
}
