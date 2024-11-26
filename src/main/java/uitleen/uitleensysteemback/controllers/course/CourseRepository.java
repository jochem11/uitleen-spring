package uitleen.uitleensysteemback.controllers.course;

import org.springframework.data.repository.CrudRepository;
import uitleen.uitleensysteemback.models.Course;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course> findAll();
}
