package umc.spring.web.dto.review;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddReviewRequest {
    @NotBlank
    private String content;

    @Min(1) @Max(5)
    private int star;

    private List<@NotBlank String> imageUrls;  // null 허용, 값이 있으면 빈 문자열 금지
}
