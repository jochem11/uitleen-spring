package uitleen.uitleensysteemback.controllers.category.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.category.CategoryRepository;
import uitleen.uitleensysteemback.models.Category;

@Service
public class CreateCategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CreateCategoryService(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void CreateCategory(final CreateCategoryRequest request) {
        categoryRepository.save(mapRequestToCategory(request));
    }

    private Category mapRequestToCategory(final CreateCategoryRequest request) {
        final Category category = new Category();
        category.setName(request.getName());
        return category;
    }
}
