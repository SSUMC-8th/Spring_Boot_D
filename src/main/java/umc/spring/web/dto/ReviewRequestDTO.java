package umc.spring.web.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.List;

public class ReviewRequestDTO {

    @Getter
    public static class ReviewJoinDTO {
        @NotBlank
        String text;

        @Min(1) @Max(5)
        Float score;

        List<String> reviewPictureList;
    }
}
