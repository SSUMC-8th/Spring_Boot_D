package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.apiPayload.code.MissionResponseDTO;
import umc.spring.domain.Mission;

import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {
    public static MissionResponseDTO.MissionPreViewDTO toMissionPreViewDTO(Mission mission){
        return MissionResponseDTO.MissionPreViewDTO.builder()
                .missionId(mission.getId())
                .price(mission.getPrice())
                .point(mission.getPoint())
                .remainDate(mission.getRemainDate())
                .storeName(mission.getStore().getName())  // storeName으로 수정
                .build();
    }

    public static MissionResponseDTO.MissionPreViewListDTO toMissionPreViewListDTO(Page<Mission> missionList) {
        List<MissionResponseDTO.MissionPreViewDTO> dtoList = missionList.stream()
                .map(MissionConverter::toMissionPreViewDTO)
                .collect(Collectors.toList());

        return MissionResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPages(missionList.getTotalPages())
                .listSize(dtoList.size())
                .missionList(dtoList)
                .build();
    }
}
