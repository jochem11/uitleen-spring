package uitleen.uitleensysteemback.controllers.group.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.group.GroupRepository;
import uitleen.uitleensysteemback.models.Group;

import java.util.List;

@Service
public class GetGroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public GetGroupService(final GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> getGroups() {
        return groupRepository.findAll();
    }
}
