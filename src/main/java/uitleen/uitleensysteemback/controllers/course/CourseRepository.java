package uitleen.uitleensysteemback.controllers.course;

import org.springframework.data.jpa.repository.JpaRepository;
import uitleen.uitleensysteemback.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
