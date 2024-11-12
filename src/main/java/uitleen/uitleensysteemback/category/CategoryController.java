package uitleen.uitleensysteemback.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uitleen.uitleensysteemback.category.create.CreateCategoryRequest;
import uitleen.uitleensysteemback.category.create.CreateCategoryService;
import uitleen.uitleensysteemback.category.deleteById.DeleteByIdCategoryService;
import uitleen.uitleensysteemback.category.edit.EditCategoryRequest;
import uitleen.uitleensysteemback.category.edit.EditCategoryService;
import uitleen.uitleensysteemback.category.get.GetCategoryService;
import uitleen.uitleensysteemback.category.getById.GetByIdCategoryService;
import uitleen.uitleensysteemback.models.Category;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CreateCategoryService createCategoryService;
    private final GetCategoryService getCategoryService;
    private final GetByIdCategoryService getByIdCategoryService;
    private final DeleteByIdCategoryService deleteByIdCategoryService;
    private final EditCategoryService editCategoryService;

    @Autowired
    public CategoryController(final CreateCategoryService createCategoryService,
                              final GetCategoryService getCategoryService,
                              final GetByIdCategoryService getByIdCategoryService,
                              final DeleteByIdCategoryService deleteByIdCategoryService,
                              final EditCategoryService editCategoryService) {
        this.createCategoryService = createCategoryService;
        this.getCategoryService = getCategoryService;
        this.getByIdCategoryService = getByIdCategoryService;
        this.deleteByIdCategoryService = deleteByIdCategoryService;
        this.editCategoryService = editCategoryService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createCategory(@RequestBody final CreateCategoryRequest request) {
        createCategoryService.CreateCategory(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        return ResponseEntity.ok(getCategoryService.getCategories());
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Optional<Category>> getCategoryById(@PathVariable final long categoryId) {
        return ResponseEntity.ok(getByIdCategoryService.getCategoryById(categoryId));
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<HttpStatus> deleteCategoryById(@PathVariable final long categoryId) {
        deleteByIdCategoryService.deleteCategoryById(categoryId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<HttpStatus> editCategory(@PathVariable final long categoryId, @RequestBody final EditCategoryRequest request) {
        editCategoryService.editCategory(categoryId, request);
        return ResponseEntity.ok().build();
    }
}