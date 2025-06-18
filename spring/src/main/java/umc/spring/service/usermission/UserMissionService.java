package umc.spring.service.usermission;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apipayload.exception.GeneralException;
import umc.spring.apipayload.status.ErrorResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.User;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.UserMission;
import umc.spring.repository.mission.MissionRepository;
import umc.spring.repository.user.UserRepository;
import umc.spring.repository.usermission.UserMissionRepository;
import umc.spring.web.dto.usermission.UserMissionRequest;
import umc.spring.web.dto.mission.MissionListResponse;

@Service
@RequiredArgsConstructor
public class UserMissionService {
    private final UserRepository userRepo;
    private final MissionRepository missionRepo;
    private final UserMissionRepository userMissionRepo;
    private final MissionConverter converter;

    @Transactional
    public UserMission apply(UserMissionRequest req) {
        var user    = userRepo.findById(Long.valueOf(req.getUserId()))
                .orElseThrow(() -> new GeneralException(ErrorResponse.MEMBER_NOT_FOUND));
        var mission = missionRepo.findById(Long.valueOf(req.getMissionId()))
                .orElseThrow(() -> new GeneralException(ErrorResponse.ARTICLE_NOT_FOUND));
        // 중복 검증은 @UniqueUserMission 에서 처리됨

        UserMission um = UserMission.builder()
                .user(user)
                .mission(mission)
                .missionStatus(MissionStatus.IN_PROGRESS)
                .build();

        return userMissionRepo.save(um);
    }

    @Transactional(readOnly = true)
    public Page<MissionListResponse> getUserMissions(Long userId, Pageable pageable) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new GeneralException(ErrorResponse.MEMBER_NOT_FOUND));

        Page<UserMission> userMissionPage = userMissionRepo
                .findAllByUserAndMissionStatus(user, MissionStatus.IN_PROGRESS, pageable);

        return userMissionPage.map(userMission -> converter.toMissionListResponse(userMission.getMission()));

    }
}
