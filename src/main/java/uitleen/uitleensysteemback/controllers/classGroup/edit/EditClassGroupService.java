package uitleen.uitleensysteemback.controllers.classGroup.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.classGroup.ClassGroupRepository;
import uitleen.uitleensysteemback.entities.ClassGroup;

@Service
public class EditClassGroupService {
    private final ClassGroupRepository classGroupRepository;

    @Autowired
    public EditClassGroupService(final ClassGroupRepository classGroupRepository) {
        this.classGroupRepository = classGroupRepository;
    }

    public void editClassGroup(final long classGroupId, final EditClassGroupRequest request) {
        final ClassGroup classGroup = classGroupRepository.findById(classGroupId).orElseThrow(() -> new IllegalArgumentException("Item not found"));
        final ClassGroup updatedClassGroup = mapRequestToClassGroup(classGroup, request);
        classGroupRepository.save(updatedClassGroup);
    }

    private ClassGroup mapRequestToClassGroup(ClassGroup classGroup, final EditClassGroupRequest request) {
        classGroup.setName(request.getName());
        return classGroup;
    }
}
