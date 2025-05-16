package umc.spring.apipayload.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueUserMissionValidator.class)
@Documented
public @interface UniqueUserMission {
    String message() default "_ALREADY_PARTICIPATING";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
