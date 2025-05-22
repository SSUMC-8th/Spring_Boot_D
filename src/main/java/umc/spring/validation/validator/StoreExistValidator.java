package umc.spring.validation.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.validation.annotation.ExistStore;

@Component
@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator<ExistStore, Long> {

    private final StoreRepository storeRepository;

    @Override
    public boolean isValid(Long storeId, ConstraintValidatorContext context) {
        if (storeId == null) return false;
//        if(!storeRepository.existsById(storeId)){
//            context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate(
//                    ErrorStatus.STORE_NOT_FOUND.toString()
//            ).addConstraintViolation();
//            return false;
//        }
        return true;
    }
}