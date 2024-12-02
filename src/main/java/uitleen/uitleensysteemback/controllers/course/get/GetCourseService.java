package uitleen.uitleensysteemback.controllers.course.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.course.CourseRepository;
import uitleen.uitleensysteemback.entities.Course;

import java.util.List;

@Service
public class GetCourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public GetCourseService(final CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<GetCourseResponse> getCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map(this::toCourseResponse).toList();
    }

    private GetCourseResponse toCourseResponse(Course course) {
        GetCourseResponse response = new GetCourseResponse();
        response.setId(course.getId());
        response.setName(course.getName());
        return response;
    }
}
