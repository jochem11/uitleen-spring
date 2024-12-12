package uitleen.uitleensysteemback.controllers.classGroup.getById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.classGroup.ClassGroupRepository;
import uitleen.uitleensysteemback.entities.ClassGroup;

import java.util.Optional;

@Service
public class GetByIdClassGroupService {
    private final ClassGroupRepository classGroupRepository;

    @Autowired
    public GetByIdClassGroupService(final ClassGroupRepository classGroupRepository) {
        this.classGroupRepository = classGroupRepository;
    }

    public Optional<GetByIdClassGroupResponse> getClassGroupById(final long classGroupId) {
        Optional<ClassGroup> group = classGroupRepository.findById(classGroupId);
        return group.map(this::toClassGroupResponse);
    }

    private GetByIdClassGroupResponse toClassGroupResponse(ClassGroup classGroup) {
        GetByIdClassGroupResponse response = new GetByIdClassGroupResponse();
        response.setId(classGroup.getId());
        response.setName(classGroup.getName());
        return response;
    }
}
