package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.validation.annotation.ExistRestaurant;

import static java.rmi.server.LogStream.log;

@Component
@RequiredArgsConstructor
public class RestaurantExistValidator implements ConstraintValidator<ExistRestaurant, Long> {

    private final StoreRepository restaurantRepository;

    @Override
    public void initialize(ExistRestaurant constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long restaurantId, ConstraintValidatorContext context) {
        boolean isValid = restaurantRepository.existsById(restaurantId);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("RESTAURANT NOT EXISTS").addConstraintViolation();
        }

        return isValid;
    }

}
