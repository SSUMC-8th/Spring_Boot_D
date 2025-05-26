package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.validation.annotation.PositivePage;
import org.springframework.stereotype.Component;

@Component
public class PageValidator implements ConstraintValidator<PositivePage, Integer> {

    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext context) {


        if (page == null || page < 0) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("PAGE MUST BE ZERO OR POSITIVE").addConstraintViolation();
            return false;
        }

        return true;
    }
}
