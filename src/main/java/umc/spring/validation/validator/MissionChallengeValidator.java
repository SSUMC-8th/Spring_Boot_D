package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.TryMissionRepository;
import umc.spring.validation.annotation.NotDuplicateMissionChallenge;
import umc.spring.web.dto.TryMissionRequestDTO;

@Component
@RequiredArgsConstructor
public class MissionChallengeValidator implements ConstraintValidator<NotDuplicateMissionChallenge, TryMissionRequestDTO.CreateTry> {

    private final TryMissionRepository tryMissionRepository;

    @Override
    public boolean isValid(TryMissionRequestDTO.CreateTry dto, ConstraintValidatorContext context) {
        if (dto.getMemberId() == null || dto.getMissionId() == null) return true; // null이면 다른 @NotNull에서 잡음

        boolean alreadyTried = tryMissionRepository.existsByMember_IdAndMission_Id(
                dto.getMemberId(),
                dto.getMissionId()
        );

        if (alreadyTried) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.ALREADY_TRIED_MISSION.name())
                    .addPropertyNode("missionId")
                    .addConstraintViolation();

            return false;
        }


        return true;
    }
}
