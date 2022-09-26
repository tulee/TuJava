package shopping.web.crud.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shopping.web.crud.entity.Prices;

import java.sql.Timestamp;

public interface PricesRepository extends JpaRepository<Prices, Timestamp> {

}
