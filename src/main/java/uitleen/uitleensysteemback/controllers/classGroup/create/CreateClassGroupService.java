package uitleen.uitleensysteemback.controllers.classGroup.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.classGroup.ClassGroupRepository;
import uitleen.uitleensysteemback.entities.ClassGroup;

@Service
public class CreateClassGroupService {
    private final ClassGroupRepository classGroupRepository;

    @Autowired
    public CreateClassGroupService(final ClassGroupRepository classGroupRepository) {
        this.classGroupRepository = classGroupRepository;
    }

    public void createClassGroup(final CreateClassGroupRequest request) {
        classGroupRepository.save(mapRequestToClassGroup(request));
    }

    private ClassGroup mapRequestToClassGroup(final CreateClassGroupRequest request) {
        final ClassGroup classGroup = new ClassGroup();
        classGroup.setName(request.getName());
        return classGroup;
    }
}
