package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.validation.annotation.ExistMember;

@Component
@RequiredArgsConstructor
public class MemberExistValidator implements ConstraintValidator<ExistMember, Long> {

    private final MemberRepository memberRepository;

    @Override
    public void initialize(ExistMember constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long memberId, ConstraintValidatorContext context) {

        boolean isValid = memberRepository.existsById(memberId);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("MEMBER_NOT_EXIST")
                    .addConstraintViolation();
        }

        return isValid;
    }
}
