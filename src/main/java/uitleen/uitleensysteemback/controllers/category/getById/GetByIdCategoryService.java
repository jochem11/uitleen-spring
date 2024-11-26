package uitleen.uitleensysteemback.controllers.category.getById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.category.CategoryRepository;
import uitleen.uitleensysteemback.models.Category;

import java.util.Optional;

@Service
public class GetByIdCategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public GetByIdCategoryService(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Optional<Category> getCategoryById(final long categoryId) {
        return categoryRepository.findById(categoryId);
    }
}
