package uitleen.uitleensysteemback.controllers.category.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.category.CategoryRepository;
import uitleen.uitleensysteemback.entities.Category;

@Service
public class EditCategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public EditCategoryService(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void editCategory(final long categoryId,final EditCategoryRequest request) {
        final Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));
        final Category newCategory = mapRequestToCategory(category, request);
        categoryRepository.save(newCategory);
    }

    private Category mapRequestToCategory(Category category, EditCategoryRequest request) {
        category.setName(request.getName());
        return category;
    }
}
