package uitleen.uitleensysteemback.controllers.category.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.category.CategoryRepository;
import uitleen.uitleensysteemback.models.Category;

import java.util.List;

@Service
public class GetCategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public GetCategoryService(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
