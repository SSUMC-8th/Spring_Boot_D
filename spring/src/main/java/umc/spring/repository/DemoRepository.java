package umc.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.DemoEntity;

public interface DemoRepository extends JpaRepository<DemoEntity, Long> {
}