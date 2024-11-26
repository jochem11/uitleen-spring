package uitleen.uitleensysteemback.controllers.group.getById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.group.GroupRepository;
import uitleen.uitleensysteemback.models.Group;

import java.util.Optional;

@Service
public class GetByIdGroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public GetByIdGroupService(final GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Optional<Group> getGroupById(final long groupId) {
        return groupRepository.findById(groupId);
    }
}
