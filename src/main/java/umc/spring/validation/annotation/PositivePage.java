package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.PageValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface PositivePage {
    String message() default "PAGE MUST BE ZERO OR POSITIVE";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
