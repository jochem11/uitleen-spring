package uitleen.uitleensysteemback.controllers.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uitleen.uitleensysteemback.entities.Category;
import uitleen.uitleensysteemback.entities.Item;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item> {

    @Query("SELECT i FROM Item i " +
            "WHERE (:name IS NULL OR LOWER(i.name) LIKE LOWER(CONCAT('%', :name, '%'))) " +
            "AND (:categoryId IS NULL OR i.categoryId = :categoryId) " +
            "AND (:itemStatusId IS NULL OR i.itemStatusId = :itemStatusId)")
    List<Item> findByFilters(@Param("name") String name,
                             @Param("categoryId") Long categoryId,
                             @Param("itemStatusId") Long itemStatusId);
}
