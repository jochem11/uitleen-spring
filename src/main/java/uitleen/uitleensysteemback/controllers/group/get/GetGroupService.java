package uitleen.uitleensysteemback.controllers.group.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.group.GroupRepository;
import uitleen.uitleensysteemback.entities.Group;

import java.util.List;

@Service
public class GetGroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public GetGroupService(final GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<GetGroupResponse> getGroups() {
        List<Group> groups = groupRepository.findAll();
        return groups.stream()
                .map(this::toGroupResponse)
                .toList();
    }

    private GetGroupResponse toGroupResponse(Group group) {
        GetGroupResponse response = new GetGroupResponse();
        response.setId(group.getId());
        response.setName(group.getName());
        return response;
    }
}
