package uitleen.uitleensysteemback.controllers.course.getById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.course.CourseRepository;
import uitleen.uitleensysteemback.entities.Course;

import java.util.Optional;

@Service
public class GetByIdCourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public GetByIdCourseService(final CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Optional<GetByIdCourseResponse> getCourseById(final long courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        return course.map(this::toGetByIdCourseResponse);
    }

    private GetByIdCourseResponse toGetByIdCourseResponse(Course course) {
        GetByIdCourseResponse response = new GetByIdCourseResponse();
        response.setId(course.getId());
        response.setName(course.getName());
        return response;
    }
}
