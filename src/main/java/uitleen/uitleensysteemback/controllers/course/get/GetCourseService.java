package uitleen.uitleensysteemback.controllers.course.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.course.CourseRepository;
import uitleen.uitleensysteemback.models.Course;

import java.util.List;

@Service
public class GetCourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public GetCourseService(final CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }
}
