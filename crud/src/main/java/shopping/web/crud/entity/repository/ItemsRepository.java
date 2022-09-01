package shopping.web.crud.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shopping.web.crud.entity.Items;

import java.util.List;

public interface ItemsRepository extends JpaRepository<Items,Integer> {
    List<Items> findByItemNameContaining(String term);
}
