package uitleen.uitleensysteemback.controllers.course.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.course.CourseRepository;
import uitleen.uitleensysteemback.models.Course;

@Service
public class EditCourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public EditCourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void editCourse(final long courseId, final EditCourseRequest request) {
        final Course course = courseRepository.findById(courseId).orElseThrow(() -> new IllegalArgumentException("Course not found"));
        courseRepository.save(mapRequestToCourse(course, request));
    }

    private Course mapRequestToCourse(final Course course, final EditCourseRequest request) {
        course.setName(request.getName());
        return course;
    }
}
