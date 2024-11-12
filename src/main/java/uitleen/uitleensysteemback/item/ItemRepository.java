package uitleen.uitleensysteemback.item;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import uitleen.uitleensysteemback.models.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends CrudRepository<Item, Long>, JpaSpecificationExecutor<Item> {
    List<Item> findAll();

    @Query("SELECT i FROM Item i " +
            "JOIN i.category c " +
            "JOIN i.itemStatus s " +
            "WHERE (:name IS NULL OR LOWER(i.name) LIKE LOWER(CONCAT('%', :name, '%'))) " +
            "AND (:categoryName IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :categoryName, '%'))) " +
            "AND (:itemStatusName IS NULL OR LOWER(s.name) LIKE LOWER(CONCAT('%', :itemStatusName, '%')))")
    List<Item> findByFilters(@Param("name") Optional<String> name,
                             @Param("categoryName") Optional<String> categoryName,
                             @Param("itemStatusName") Optional<String> itemStatusName);
}
