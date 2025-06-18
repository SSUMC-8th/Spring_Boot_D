package umc.spring.web.dto.review;

public class AddReviewResponse {
    private Long reviewId;
    public AddReviewResponse(Long reviewId) { this.reviewId = reviewId; }
    public Long getReviewId() { return reviewId; }

}
