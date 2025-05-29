package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MyMissionConverter;
import umc.spring.converter.MyReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.TryMission;
import umc.spring.service.MemberService.MemberCommandService;
import umc.spring.service.MemberService.MemberQueryService;
import umc.spring.service.MissionService.TryMissionQueryServiceImpl;
import umc.spring.validation.annotation.ValidPage;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;
import umc.spring.web.dto.MyMissionResponseDTO;
import umc.spring.web.dto.MyReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;
    private final TryMissionQueryServiceImpl tryMissionQueryService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @GetMapping("/{memberId}/reviews")
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API", description = "사용자가 작성한 리뷰 목록을 페이징 형식으로 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MEMBER4001", description = "회원을 찾을 수 없습니다."),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON400", description = "잘못된 page 값입니다.")
    })
    @Parameters({
            @Parameter(name = "memberId", description = "리뷰를 조회할 회원 ID", in = ParameterIn.PATH, required = true),
            @Parameter(name = "page", description = "조회할 페이지 번호 (1부터 시작)", in = ParameterIn.QUERY, required = true)
    })
    public ApiResponse<MyReviewResponseDTO.MyReviewListDTO> getMyReviewList(
            @PathVariable(name = "memberId") Long memberId,
            @ValidPage @RequestParam(name = "page") Integer page
    ) {
        Page<Review> reviewPage = memberQueryService.getMyReviews(memberId, page - 1);
        return ApiResponse.onSuccess(MyReviewConverter.toMyReviewListDTO(
                reviewPage.getContent(),
                reviewPage.getNumberOfElements(),
                reviewPage.getTotalPages(),
                reviewPage.getTotalElements(),
                reviewPage.isFirst(),
                reviewPage.isLast()
        ));
    }

    @GetMapping("/{memberId}/missions")
    @Operation(summary = "내가 진행 중인 미션 목록 조회 API", description = "로그인한 사용자가 도전 중인 미션 목록을 페이징으로 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MEMBER4001", description = "회원을 찾을 수 없습니다."),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON400", description = "잘못된 page 값입니다.")
    })
    @Parameters({
            @Parameter(name = "memberId", description = "회원 ID", in = ParameterIn.PATH, required = true),
            @Parameter(name = "page", description = "페이지 번호 (1부터 시작)", in = ParameterIn.QUERY, required = true)
    })
    public ApiResponse<MyMissionResponseDTO.MyMissionListDTO> getMyMissions(
            @PathVariable("memberId") Long memberId,
            @ValidPage @RequestParam(name = "page") Integer page
    ) {
        Page<TryMission> tryMissionPage = tryMissionQueryService.getMyInProgressMissions(memberId, PageRequest.of(page - 1, 10));
        return ApiResponse.onSuccess(MyMissionConverter.toMyMissionListDTO(tryMissionPage));
    }


}
