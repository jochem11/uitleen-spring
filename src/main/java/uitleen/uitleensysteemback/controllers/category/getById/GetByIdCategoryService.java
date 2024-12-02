package uitleen.uitleensysteemback.controllers.category.getById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.category.CategoryRepository;
import uitleen.uitleensysteemback.entities.Category;

import java.util.Optional;

@Service
public class GetByIdCategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public GetByIdCategoryService(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Optional<GetByIdCategoryResponse> getCategoryById(final long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        return category.map(this::toGetByIdCategoryResponse);
    }

    private GetByIdCategoryResponse toGetByIdCategoryResponse(Category category) {
        GetByIdCategoryResponse response = new GetByIdCategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        return response;
    }
}
