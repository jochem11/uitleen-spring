package uitleen.uitleensysteemback.controllers.group.deleteById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.group.GroupRepository;

@Service
public class DeleteByIdGroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public DeleteByIdGroupService(final GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public void deleteGroupById(final long groupId) {
        groupRepository.deleteById(groupId);
    }
}
