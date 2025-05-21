package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.RegionRepository;
import umc.spring.validation.annotation.RegionExists;

@Component
@RequiredArgsConstructor
public class RegionExistsValidator implements ConstraintValidator<RegionExists, Long> {

    private final RegionRepository regionRepository;

    @Override
    public boolean isValid(Long regionId, ConstraintValidatorContext context) {
        boolean exists = regionRepository.existsById(regionId);

        if (!exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.TEMP_EXCEPTION.getMessage())
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}