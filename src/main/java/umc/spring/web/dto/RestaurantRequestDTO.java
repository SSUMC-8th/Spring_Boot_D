package umc.spring.web.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class RestaurantRequestDTO {

    @NotNull(message = "지역 ID는 필수입니다.")
    private Long regionId;

    @NotBlank(message = "식당 이름은 필수입니다.")
    private String restaurantName;

    @NotBlank(message = "카테고리는 필수입니다.")
    private String category;

    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "5.0", inclusive = true)
    private Float rating;
}
