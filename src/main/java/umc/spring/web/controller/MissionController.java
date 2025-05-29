package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.apiPayload.code.MemberMissionPreViewListDTO;
import umc.spring.apiPayload.code.MissionResponseDTO;
import umc.spring.apiPayload.code.MissionStatus;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MissionQueryService;
import umc.spring.validation.annotation.ExistStore;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionQueryService missionQueryService;

    @GetMapping("/{storeId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "storeId 기준, 쿼리스트링 page 포함")
    public ApiResponse<MissionResponseDTO.MissionPreViewListDTO> getMissionList(
            @ExistStore @PathVariable Long storeId,
            @PositivePage @RequestParam(name = "page") Integer page) {

        Page<Mission> missionList = missionQueryService.getMissionList(storeId, page);
        return ApiResponse.onSuccess(MissionConverter.toMissionPreViewListDTO(missionList));
    }
    @GetMapping("/{memberId}/missions")
    public ApiResponse<MemberMissionPreViewListDTO> getMyMissions(
            @PathVariable Long memberId,
            @PositivePage @RequestParam(name = "page") Integer page,
            @RequestParam(name = "missionStatus", required = false) MissionStatus missionStatus) {

        Page<MemberMission> missionList = memberMissionQueryService.getMemberMissionList(memberId, missionStatus, page);
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionPreViewListDTO(missionList));
    }
}
