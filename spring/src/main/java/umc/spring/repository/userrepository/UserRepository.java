package umc.spring.repository.userrepository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}
