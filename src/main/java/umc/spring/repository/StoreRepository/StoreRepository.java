package umc.spring.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Restaurant;

public interface StoreRepository extends JpaRepository<Restaurant, Long>, StoreRepositoryCustom {

}
