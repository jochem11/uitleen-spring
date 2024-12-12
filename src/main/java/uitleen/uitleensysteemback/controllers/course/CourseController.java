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
import uitleen.uitleensysteemback.controllers.course.get.GetCourseResponse;
import uitleen.uitleensysteemback.controllers.course.get.GetCourseService;
import uitleen.uitleensysteemback.controllers.course.getById.GetByIdCourseResponse;
import uitleen.uitleensysteemback.controllers.course.getById.GetByIdCourseService;
import uitleen.uitleensysteemback.controllers.course.paged.PagedCourseResponse;
import uitleen.uitleensysteemback.controllers.course.paged.PagedCourseService;
import uitleen.uitleensysteemback.entities.Course;
import uitleen.uitleensysteemback.models.PagedResponse;

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
    private final PagedCourseService pagedCourseService;

    @Autowired
    public CourseController(final GetCourseService getCourseService, GetByIdCourseService getByIdCourseService, EditCourseService editCourseService, CreateCourseService createCourseService, DeleteByIdCourseService deleteByIdCourseService, PagedCourseService pagedCourseService) {
        this.getCourseService = getCourseService;
        this.getByIdCourseService = getByIdCourseService;
        this.editCourseService = editCourseService;
        this.createCourseService = createCourseService;
        this.deleteByIdCourseService = deleteByIdCourseService;
        this.pagedCourseService = pagedCourseService;
    }

    @GetMapping
    public List<GetCourseResponse> getCourses() {
        return getCourseService.getCourses();
    }

    @GetMapping("/{courseId}")
    public Optional<GetByIdCourseResponse> getCourseById(@PathVariable final long courseId) {
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

    @GetMapping("/paged")
    public PagedResponse<PagedCourseResponse> getPagedCourses(@RequestParam(defaultValue = "0") final int page, @RequestParam(defaultValue = "20") final int size) {
        return pagedCourseService.getPagedCourses(page, size);
    }
}
