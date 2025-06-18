package umc.spring.web.dto.review;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ReviewListResponse {
    private Long reviewId;
    private int star;
    private String content;
    private LocalDateTime createdAt;
}
