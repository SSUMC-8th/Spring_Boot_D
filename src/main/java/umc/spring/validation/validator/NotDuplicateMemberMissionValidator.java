package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.repository.MemberRepository.MemberMissionRepository;
import umc.spring.validation.annotation.NotDuplicatedMemberMission;
import umc.spring.web.dto.MemberMissionRequestDTO;

@Component
@RequiredArgsConstructor
public class NotDuplicateMemberMissionValidator implements ConstraintValidator<NotDuplicatedMemberMission, MemberMissionRequestDTO.MemberMissionJoinDTO> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(MemberMissionRequestDTO.MemberMissionJoinDTO dto, ConstraintValidatorContext context) {
        if (dto.getMemberId() == null || dto.getMissionId() == null) return true;
        return !memberMissionRepository.existsByMemberIdAndMissionId(dto.getMemberId(), dto.getMissionId());
    }
}
