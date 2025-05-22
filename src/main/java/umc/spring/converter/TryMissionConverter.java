package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.TryMission;
import umc.spring.domain.TryMissionId;

import java.time.Instant;
import java.util.UUID;

public class TryMissionConverter {

    public static TryMission toTryMission(Member member, Mission mission) {

        TryMissionId tryMissionId = new TryMissionId();
        tryMissionId.setMemberId(member.getId());
        tryMissionId.setMissionId(mission.getId());
        tryMissionId.setTryMissionId(generateTryMissionId());

        return TryMission.builder()
                .id(tryMissionId)
                .member(member)
                .mission(mission)
                .status("inprogress")
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();
    }
    private static Long generateTryMissionId() { // mission_id랑 restaurant_id가 복합pk여서 auto_increment안됨 -> 수동으로
        return Math.abs(UUID.randomUUID().getMostSignificantBits());
    }

}
