package uitleen.uitleensysteemback.controllers.course.paged;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.course.CourseRepository;
import uitleen.uitleensysteemback.entities.Course;
import uitleen.uitleensysteemback.models.PagedResponse;
import uitleen.uitleensysteemback.utils.SortUtils;

@Service
public class PagedCourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public PagedCourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public PagedResponse<PagedCourseResponse> getPagedCourses(final int page, final int size, final String sortBy, final String sortDir) {
        Sort sort = SortUtils.getPagedSort(PagedCourseResponse.class, sortBy, sortDir);

        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Course> courses = courseRepository.findAll(pageRequest);

        Page<PagedCourseResponse> pagedCourseResponses = courses.map(this::toPagedCourseResponse);
        return new PagedResponse<>(pagedCourseResponses);
    }

    private PagedCourseResponse toPagedCourseResponse(Course course) {
        PagedCourseResponse response = new PagedCourseResponse();
        response.setId(course.getId());
        response.setName(course.getName());
        return response;
    }
}
