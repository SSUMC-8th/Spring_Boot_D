package umc.spring.apipayload.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.PARAMETER, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExistingStoreValidator.class)
@Documented
public @interface ExistingStore {
    // ErrorResponse enum 의 이름과 동일해야 ExceptionAdvice 에서 매핑됩니다
    String message() default "STORE_NOT_FOUND";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
