package umc.spring.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberMissionPreViewDTO {
    private Long memberMissionId;
    private String missionCode;
    private MissionStatus missionStatus;
    private Long missionId;
    private Integer price;
    private Integer point;
    private LocalDate remainDate;
    private String storeName;
}