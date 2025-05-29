package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.apiPayload.code.MemberMissionPreViewDTO;
import umc.spring.apiPayload.code.MemberMissionPreViewListDTO;
import umc.spring.domain.mapping.MemberMission;

import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {
    public static MemberMissionPreViewDTO toMemberMissionPreViewDTO(MemberMission memberMission) {
        return MemberMissionPreViewDTO.builder()
                .memberMissionId(memberMission.getId())
                .missionCode(memberMission.getMissionCode())
                //.missionStatus(memberMission.getMissionStatus())
                .missionId(memberMission.getMission().getId())
                .price(memberMission.getMission().getPrice())
                .point(memberMission.getMission().getPoint())
                //.remainDate(memberMission.getMission().getRemainDate())
                .storeName(memberMission.getMission().getStore().getName()) // store로 수정
                .build();
    }

    public static MemberMissionPreViewListDTO toMemberMissionPreViewListDTO(Page<MemberMission> missionPage) {
        List<MemberMissionPreViewDTO> dtoList = missionPage.stream()
                .map(MemberMissionConverter::toMemberMissionPreViewDTO)
                .collect(Collectors.toList());

        return MemberMissionPreViewListDTO.builder()
                .isLast(missionPage.isLast())
                .isFirst(missionPage.isFirst())
                .totalPages(missionPage.getTotalPages())
                .totalElements(missionPage.getTotalElements())
                .listSize(dtoList.size())
                .memberMissionList(dtoList)
                .build();
    }
}
