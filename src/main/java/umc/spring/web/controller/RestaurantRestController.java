package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.service.MissionService.MissionQueryService;
import umc.spring.service.RestaurantService.RestaurantCommandService;
import umc.spring.service.RestaurantService.RestaurantQueryService;
import umc.spring.validation.annotation.ExistRestaurant;
import umc.spring.validation.annotation.ValidPage;
import umc.spring.web.dto.MissionListDTO;
import umc.spring.web.dto.RestaurantRequestDTO;
import umc.spring.web.dto.RestaurantReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/restaurants")
public class RestaurantRestController {

    private final RestaurantCommandService restaurantCommandService;
    private final RestaurantQueryService restaurantQueryService;
    private final MissionQueryService missionQueryService;

    @PostMapping
    public ApiResponse<String> createRestaurant(@RequestBody @Valid RestaurantRequestDTO request) {
        var restaurant = restaurantCommandService.addRestaurant(request);
        return ApiResponse.onSuccess("식당이 성공적으로 등록되었습니다. ID: " + restaurant.getId());
    }

    @GetMapping("/{restaurantId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰들을 페이지별로 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "RESTAURANT4001", description = "가게를 찾을 수 없습니다."),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON400", description = "잘못된 page 값입니다.")
    })
    @Parameters({
            @Parameter(name = "restaurantId", description = "리뷰를 조회할 대상 가게의 ID", in = ParameterIn.PATH, required = true),
            @Parameter(name = "page", description = "조회할 페이지 번호 (1부터 시작)", in = ParameterIn.QUERY, required = true)
    })
    public ApiResponse<RestaurantReviewResponseDTO.ReviewPreviewListDTO> getRestaurantReviews(
            @ExistRestaurant @PathVariable(name = "restaurantId") Long restaurantId,
            @ValidPage @RequestParam(name = "page") Integer page
    ) {
        Page<Review> reviewPage = restaurantQueryService.getReviewList(restaurantId, page - 1); // 1-based → 0-based
        return ApiResponse.onSuccess(RestaurantConverter.toReviewPreviewListDTO(reviewPage));
    }

    @GetMapping("/{restaurantId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "특정 가게의 미션들을 페이지별로 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "RESTAURANT4001", description = "가게를 찾을 수 없습니다."),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON400", description = "잘못된 page 값입니다.")
    })
    @Parameters({
            @Parameter(name = "restaurantId", description = "미션을 조회할 대상 가게의 ID", in = ParameterIn.PATH, required = true),
            @Parameter(name = "page", description = "조회할 페이지 번호 (1부터 시작)", in = ParameterIn.QUERY, required = true)
    })
    public ApiResponse<MissionListDTO> getMissions(
            @ExistRestaurant @PathVariable(name = "restaurantId") Long restaurantId,
            @ValidPage @RequestParam(name = "page") Integer page
    ) {
        Page<Mission> missions = missionQueryService.getMissionsByRestaurant(restaurantId, page - 1);
        return ApiResponse.onSuccess(MissionConverter.toListDTO(missions));
    }

}
