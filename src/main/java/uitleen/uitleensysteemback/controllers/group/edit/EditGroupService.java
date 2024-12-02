package uitleen.uitleensysteemback.controllers.group.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.group.GroupRepository;
import uitleen.uitleensysteemback.entities.Group;

@Service
public class EditGroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public EditGroupService(final GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public void editGroup(final long groupId, final EditGroupRequest request) {
        final Group group = groupRepository.findById(groupId).orElseThrow(() -> new IllegalArgumentException("Item not found"));
        final Group updatedGroup = mapRequestToGroup(group, request);
        groupRepository.save(updatedGroup);
    }

    private Group mapRequestToGroup(Group group, final EditGroupRequest request) {
        group.setName(request.getName());
        return group;
    }
}
