package umc.spring.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
    // 다른 쿼리 메서드
}