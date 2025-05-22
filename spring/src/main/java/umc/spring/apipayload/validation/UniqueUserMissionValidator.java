package umc.spring.apipayload.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import umc.spring.repository.usermission.UserMissionRepository;
import umc.spring.web.dto.usermission.UserMissionRequest;

@Component
public class UniqueUserMissionValidator implements ConstraintValidator<UniqueUserMission, UserMissionRequest> {
    @Autowired private UserMissionRepository repo;

    @Override
    public boolean isValid(UserMissionRequest req, ConstraintValidatorContext ctx) {
        if (req==null) return true;
        boolean exists = repo.existsByUser_IdAndMission_Id( req.getUserId(),
                req.getMissionId());
        if (exists) {
            ctx.disableDefaultConstraintViolation();
            ctx.buildConstraintViolationWithTemplate("_ALREADY_PARTICIPATING")
                    .addPropertyNode("missionId")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}