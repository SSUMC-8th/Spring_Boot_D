package umc.spring.apipayload.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.repository.user.UserRepository;

@Component
@RequiredArgsConstructor
public class ExistingUserValidator implements ConstraintValidator<ExistingUser, Long> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(Long userId, ConstraintValidatorContext context) {
        if (userId == null) return true;  // @NotNull 로 별도 처리

        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("MEMBER_NOT_FOUND")
                    .addConstraintViolation();
        }
        return exists;
    }
}
