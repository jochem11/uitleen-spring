package uitleen.uitleensysteemback.controllers.classGroup.paged;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.classGroup.ClassGroupRepository;
import uitleen.uitleensysteemback.controllers.course.paged.PagedCourseResponse;
import uitleen.uitleensysteemback.entities.ClassGroup;
import uitleen.uitleensysteemback.models.PagedResponse;
import uitleen.uitleensysteemback.utils.SortUtils;

@Service
public class PagedClassGroupService {
    private final ClassGroupRepository classGroupRepository;

    @Autowired
    public PagedClassGroupService(ClassGroupRepository classGroupRepository) {
        this.classGroupRepository = classGroupRepository;
    }

    public PagedResponse<PagedClassGroupResponse> getPagedClassGroups(final int page, final int size, final String sortBy, final String sortDir) {
        Sort sort = SortUtils.getPagedSort(PagedClassGroupResponse.class, sortBy, sortDir);

        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<ClassGroup> classGroups = classGroupRepository.findAll(pageRequest);
        Page<PagedClassGroupResponse> pagedClassGroups = classGroups.map(this::toPagedClassGroupResponse);

        return new PagedResponse<>(pagedClassGroups);
    }

    private PagedClassGroupResponse toPagedClassGroupResponse(final ClassGroup classGroup) {
        PagedClassGroupResponse response = new PagedClassGroupResponse();
        response.setId(classGroup.getId());
        response.setName(classGroup.getName());
        return response;
    }
}
