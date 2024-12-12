package uitleen.uitleensysteemback.controllers.category.paged;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uitleen.uitleensysteemback.controllers.category.CategoryRepository;
import uitleen.uitleensysteemback.entities.Category;
import uitleen.uitleensysteemback.models.PagedResponse;

@Service
public class PagedCategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public PagedCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public PagedResponse<PagedCategoryResponse> getPagedCategories(final int page, final int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Category> categories = categoryRepository.findAll(pageRequest);
        Page<PagedCategoryResponse> pagedCategoryResponses = categories.map(this::toPagedCategoryResponse);
        return new PagedResponse<>(pagedCategoryResponses);
    }

    private PagedCategoryResponse toPagedCategoryResponse(Category category) {
        PagedCategoryResponse response = new PagedCategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        return response;
    }
}
