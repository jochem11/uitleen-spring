package uitleen.uitleensysteemback.controllers.category;

import org.springframework.data.jpa.repository.JpaRepository;
import uitleen.uitleensysteemback.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
