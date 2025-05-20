package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public class RestaurantRequestDTO {

    @Getter
    public static class JoinDTO {
        @NotBlank
        @Size(max = 25)
        String name;

        @NotBlank
        @Size(max = 25)
        String type;

        @NotNull
        Float score;

        String time;

        @NotNull
        Long regionId;
    }
}
