package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/{restaurantId}/review")
    public ApiResponse<ReviewResponseDTO.ReviewJoinResultDTO> join(
            @PathVariable Long restaurantId,
            @RequestBody @Valid ReviewRequestDTO.ReviewJoinDTO request) {
        Review review = reviewCommandService.joinReview(restaurantId, request);
        return ApiResponse.onSuccess(ReviewConverter.toJoinResultDTO(review));
    }
}
