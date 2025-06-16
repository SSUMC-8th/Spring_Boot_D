package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberService.MemberCommandService;
import umc.spring.service.MemberService.MemberMissionQueryService;
import umc.spring.service.MemberService.MemberQueryService;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.ExistRestaurant;
import umc.spring.validation.annotation.PositivePage;
import umc.spring.web.dto.MemberMissionResponseDTO;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;
import umc.spring.web.dto.RestaurantResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;
    private final MemberMissionQueryService memberMissionQueryService;

    @PostMapping("/join")
    public ApiResponse<MemberResponseDTO.MemberJoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.MemberJoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @GetMapping("/{memberId}/reviews")
    @Operation(summary = "특정 멤버의 리뷰 목록 조회 API", description = "특정 멤버가 작성한 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "memberId", description = "멤버의 아이디, path variable 입니다!")
    })
    public ApiResponse<RestaurantResponseDTO.ReviewPreViewListDTO> getReviewList(
            @ExistMember @PathVariable(name = "memberId") Long memberId,
            @PositivePage @RequestParam(name = "page") Integer page) {
        Page<Review> reviewList = memberQueryService.getReviewList(memberId, page);
        return ApiResponse.onSuccess(RestaurantConverter.reviewPreViewListDTO(reviewList));
    }

    @GetMapping("/{memberId}/missions")
    @Operation(summary = "특정 멤버의 미션 목록 조회 API", description = "특정 멤버의 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호와 Mission Status를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "memberId", description = "멤버의 아이디, path variable 입니다!"),
            @Parameter(name = "missionStatus", description = "미션 상태(INPROGRESS, COMPLETE)를 설정하거나 빈 값으로 요청하면 미션 전체 조회")
    })
    public ApiResponse<MemberMissionResponseDTO.MemberMissionPreViewListDTO> getMemberMissionList (
            @ExistMember @PathVariable(name = "memberId") Long memberId,
            @PositivePage @RequestParam(name = "page") Integer page,
            @RequestParam(name = "missionStatus", required = false) MissionStatus missionStatus) {
        Page<MemberMission> memberMissionList = memberMissionQueryService.getMemberMissionList(memberId, missionStatus,page);
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionPreViewListDTO(memberMissionList));
    }

    @PostMapping("/login")
    @Operation(summary = "유저 로그인 API", description = "유저가 로그인하는 API입니다.")
    public ApiResponse<MemberResponseDTO.LoginResultDTO> login(@RequestBody @Valid MemberRequestDTO.LoginRequestDTO request) {
        return ApiResponse.onSuccess(memberCommandService.loginMember(request));
    }

    @GetMapping("/info")
    @Operation(summary = "유저 내 정보 조회 API - 인증 필요",
    description = "유저가 내 정보를 조회하는 API입니다.",
    security = { @SecurityRequirement(name = "JWT TOKEN") }
    )
    public ApiResponse<MemberResponseDTO.MemberInfoDTO> getMyInfo(HttpServletRequest request) {
        return ApiResponse.onSuccess(memberQueryService.getMemberInfo(request));
    }

}