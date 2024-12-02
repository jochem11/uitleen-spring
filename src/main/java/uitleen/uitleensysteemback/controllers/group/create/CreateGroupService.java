package uitleen.uitleensysteemback.controllers.group.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.group.GroupRepository;
import uitleen.uitleensysteemback.entities.Group;

@Service
public class CreateGroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public CreateGroupService(final GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public void createGroup(final CreateGroupRequest request) {
        groupRepository.save(mapRequestToGroup(request));
    }

    private Group mapRequestToGroup(final CreateGroupRequest request) {
        final Group group = new Group();
        group.setName(request.getName());
        return group;
    }
}
