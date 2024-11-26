package uitleen.uitleensysteemback.controllers.course.deleteById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.course.CourseRepository;

@Service
public class DeleteByIdCourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public DeleteByIdCourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void deleteById(final long courseId) {
        courseRepository.deleteById(courseId);
    }
}
