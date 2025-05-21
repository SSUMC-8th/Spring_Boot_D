package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.MissionNotDuplicatedValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionNotDuplicatedValidator.class)
@Target({ElementType.PARAMETER}) // PathVariable
@Retention(RetentionPolicy.RUNTIME)
public @interface MissionNotDuplicated {

    String message() default "이미 도전한 미션입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}