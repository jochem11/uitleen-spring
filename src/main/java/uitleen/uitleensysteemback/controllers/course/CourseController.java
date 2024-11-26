package uitleen.uitleensysteemback.controllers.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uitleen.uitleensysteemback.controllers.course.create.CreateCourseRequest;
import uitleen.uitleensysteemback.controllers.course.create.CreateCourseService;
import uitleen.uitleensysteemback.controllers.course.deleteById.DeleteByIdCourseService;
import uitleen.uitleensysteemback.controllers.course.edit.EditCourseRequest;
import uitleen.uitleensysteemback.controllers.course.edit.EditCourseService;
import uitleen.uitleensysteemback.controllers.course.get.GetCourseService;
import uitleen.uitleensysteemback.controllers.course.getById.GetByIdCourseService;
import uitleen.uitleensysteemback.models.Course;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final GetCourseService getCourseService;
    private final GetByIdCourseService getByIdCourseService;
    private final EditCourseService editCourseService;
    private final CreateCourseService createCourseService;
    private final DeleteByIdCourseService deleteByIdCourseService;

    @Autowired
    public CourseController(final GetCourseService getCourseService, GetByIdCourseService getByIdCourseService, EditCourseService editCourseService, CreateCourseService createCourseService, DeleteByIdCourseService deleteByIdCourseService) {
        this.getCourseService = getCourseService;
        this.getByIdCourseService = getByIdCourseService;
        this.editCourseService = editCourseService;
        this.createCourseService = createCourseService;
        this.deleteByIdCourseService = deleteByIdCourseService;
    }

    @GetMapping
    public List<Course> getCourses() {
        return getCourseService.getCourses();
    }

    @GetMapping("/{courseId}")
    public Optional<Course> getCourseById(final long courseId) {
        return getByIdCourseService.getCourseById(courseId);
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<HttpStatus> editCourse(@PathVariable final long courseId, @RequestBody final EditCourseRequest request) {
        editCourseService.editCourse(courseId, request);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createCourse(@RequestBody final CreateCourseRequest request) {
        createCourseService.createCourse(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourseById(@PathVariable final long courseId) {
        deleteByIdCourseService.deleteById(courseId);
        return ResponseEntity.ok().build();
    }
}
