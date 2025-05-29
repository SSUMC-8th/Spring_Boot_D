package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.domain.TryMission;
import umc.spring.service.MissionService.TryMissionCommandService;
import umc.spring.web.dto.TryMissionRequestDTO;
import umc.spring.web.dto.TryMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class TryMissionController {

    private final TryMissionCommandService tryMissionCommandService;

    @PostMapping("/try")
    public ApiResponse<TryMissionResponseDTO.TryResult> tryMission(@RequestBody @Valid TryMissionRequestDTO.CreateTry request) {
        TryMission tryMission = tryMissionCommandService.tryMission(
                request.getMemberId(),
                request.getMissionId()
        );

        return ApiResponse.onSuccess(TryMissionResponseDTO.TryResult.from(tryMission));
    }

    @PatchMapping("/complete")
    @Operation(summary = "도전 중인 미션 완료 처리 API", description = "사용자가 도전 중인 미션을 완료 상태로 바꿉니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "TRYMISSION404", description = "도전 중인 미션을 찾을 수 없습니다."),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "회원 ID", required = true, in = ParameterIn.QUERY),
            @Parameter(name = "missionId", description = "미션 ID", required = true, in = ParameterIn.QUERY)
    })
    public ApiResponse<String> completeMission(
            @Parameter(name = "memberId", description = "회원 ID", required = true)
            @RequestParam(name = "memberId") Long memberId,

            @Parameter(name = "missionId", description = "미션 ID", required = true)
            @RequestParam(name = "missionId") Long missionId

    ) {
        tryMissionCommandService.completeMission(memberId, missionId);
        return ApiResponse.onSuccess("미션이 완료 처리되었습니다.");
    }


}

