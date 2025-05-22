package umc.spring.apipayload.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import umc.spring.repository.store.StoreRepository;

@Component
public class ExistingStoreValidator
        implements ConstraintValidator<ExistingStore, Long> {

    private final StoreRepository storeRepo;

    @Autowired
    public ExistingStoreValidator(StoreRepository storeRepo) {
        this.storeRepo = storeRepo;
    }

    @Override
    public boolean isValid(Long storeId, ConstraintValidatorContext ctx) {
        if (storeId == null) {
            return true;  // @NotNull 이 따로 걸린다면 그쪽에서 잡힙니다
        }
        boolean exists = storeRepo.existsById(storeId);
        if (!exists) {
            ctx.disableDefaultConstraintViolation();
            ctx.buildConstraintViolationWithTemplate("STORE_NOT_FOUND")
                    .addConstraintViolation();
        }
        return exists;
    }
}