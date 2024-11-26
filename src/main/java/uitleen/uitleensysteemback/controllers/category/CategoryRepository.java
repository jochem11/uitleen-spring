package uitleen.uitleensysteemback.controllers.category;

import org.springframework.data.repository.CrudRepository;
import uitleen.uitleensysteemback.models.Category;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();
}
