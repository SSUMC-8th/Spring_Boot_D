package umc.spring.repository;

import org.springframework.data.repository.CrudRepository;
import umc.spring.entity.Coffee;

public interface CoffeeRepository extends CrudRepository<Coffee, String> {
}
