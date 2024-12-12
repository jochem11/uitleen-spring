package uitleen.uitleensysteemback.controllers.classGroup.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.classGroup.ClassGroupRepository;
import uitleen.uitleensysteemback.entities.ClassGroup;

import java.util.List;

@Service
public class GetClassGroupService {
    private final ClassGroupRepository classGroupRepository;

    @Autowired
    public GetClassGroupService(final ClassGroupRepository classGroupRepository) {
        this.classGroupRepository = classGroupRepository;
    }

    public List<GetClassGroupResponse> getClassGroup() {
        List<ClassGroup> classGroups = classGroupRepository.findAll();
        return classGroups.stream()
                .map(this::toClassGroupResponse)
                .toList();
    }

    private GetClassGroupResponse toClassGroupResponse(ClassGroup classGroup) {
        GetClassGroupResponse response = new GetClassGroupResponse();
        response.setId(classGroup.getId());
        response.setName(classGroup.getName());
        return response;
    }
}
