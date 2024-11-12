package uitleen.uitleensysteemback.category.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.category.CategoryRepository;
import uitleen.uitleensysteemback.models.Category;

@Service
public class CreateCategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CreateCategoryService(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void CreateCategory(final CreateCategoryRequest request) {
        final Category category = mapRequestToCategory(request);
        categoryRepository.save(category);
    }

    private Category mapRequestToCategory(final CreateCategoryRequest request) {
        final Category category = new Category();
        category.setName(request.getName());
        return category;
    }
}
