package umc.spring.web.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class StoreRequestDTO {

    @Schema(description = "가게 이름", example = "김밥천국")
    @NotBlank(message = "가게 이름은 필수입니다.")
    private String name;

    @Schema(description = "가게 설명", example = "저렴하고 맛있는 김밥집")
    private String description;
}