package uitleen.uitleensysteemback.controllers.category.deleteById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.category.CategoryRepository;

@Service
public class DeleteByIdCategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public DeleteByIdCategoryService(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void deleteCategoryById(final long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
