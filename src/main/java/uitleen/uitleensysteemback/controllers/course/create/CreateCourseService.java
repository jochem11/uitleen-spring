package uitleen.uitleensysteemback.controllers.course.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.course.CourseRepository;
import uitleen.uitleensysteemback.entities.Course;

@Service
public class CreateCourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CreateCourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void createCourse(CreateCourseRequest request) {
        courseRepository.save(mapRequestToCourse(request));
    }

    private Course mapRequestToCourse(final CreateCourseRequest request) {
        final Course course = new Course();
        course.setName(request.getName());
        return course;
    }
}
