package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.repository.RestaurantRepository.RestaurantRepository;
import umc.spring.validation.annotation.ExistRestaurant;

@Component
@RequiredArgsConstructor
public class RestaurantExistValidator implements ConstraintValidator<ExistRestaurant, Long> {

    private final RestaurantRepository restaurantRepository;

    @Override
    public boolean isValid(Long restaurantId, ConstraintValidatorContext context) {
        boolean exists = restaurantRepository.existsById(restaurantId);

        if (!exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("RESTAURANT_NOT_FOUND")
                    .addConstraintViolation();
        }

        return exists;
    }
}
