package uitleen.uitleensysteemback.controllers.category.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.category.CategoryRepository;
import uitleen.uitleensysteemback.entities.Category;

import java.util.List;

@Service
public class GetCategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public GetCategoryService(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<GetCategoryResponse> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(this::toCategoryResponse)
                .toList();
    }

    private GetCategoryResponse toCategoryResponse(Category category) {
        GetCategoryResponse response = new GetCategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        return response;
    }
}
