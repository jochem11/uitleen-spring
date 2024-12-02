package uitleen.uitleensysteemback.controllers.group.getById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.group.GroupRepository;
import uitleen.uitleensysteemback.entities.Group;

import java.util.Optional;

@Service
public class GetByIdGroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public GetByIdGroupService(final GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Optional<GetByIdGroupResponse> getGroupById(final long groupId) {
        Optional<Group> group = groupRepository.findById(groupId);
        return group.map(this::toGroupResponse);
    }

    private GetByIdGroupResponse toGroupResponse(Group group) {
        GetByIdGroupResponse response = new GetByIdGroupResponse();
        response.setId(group.getId());
        response.setName(group.getName());
        return response;
    }
}
