package uitleen.uitleensysteemback.controllers.classGroup.deleteById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.classGroup.ClassGroupRepository;

@Service
public class DeleteByIdClassGroupService {
    private final ClassGroupRepository classGroupRepository;

    @Autowired
    public DeleteByIdClassGroupService(final ClassGroupRepository classGroupRepository) {
        this.classGroupRepository = classGroupRepository;
    }

    public void deleteClassGroupById(final long classGroupId) {
        classGroupRepository.deleteById(classGroupId);
    }
}
