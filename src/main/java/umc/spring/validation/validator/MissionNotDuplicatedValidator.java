package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.validation.annotation.MissionNotDuplicated;

@Component
@RequiredArgsConstructor
public class MissionNotDuplicatedValidator implements ConstraintValidator<MissionNotDuplicated, Long> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        Long hardcodedMemberId = 1L;

        boolean alreadyChallenged = memberMissionRepository.existsByMemberIdAndMissionId(hardcodedMemberId, missionId);

        if (alreadyChallenged) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.TEMP_EXCEPTION.getMessage())
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}