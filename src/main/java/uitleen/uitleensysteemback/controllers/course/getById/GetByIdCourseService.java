package uitleen.uitleensysteemback.controllers.course.getById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.course.CourseRepository;
import uitleen.uitleensysteemback.models.Course;

import java.util.Optional;

@Service
public class GetByIdCourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public GetByIdCourseService(final CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Optional<Course> getCourseById(final long courseId) {
        return courseRepository.findById(courseId);
    }
}
