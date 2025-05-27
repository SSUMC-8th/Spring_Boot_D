package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {

    public static MemberMission toEntity(Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .missionStatus(MissionStatus.INPROGRESS)
                .build();
    }

    public static MemberMissionResponseDTO.MemberMissionJoinResultDTO toJoinResultDTO(MemberMission memberMission) {
            return MemberMissionResponseDTO.MemberMissionJoinResultDTO.builder()
                    .memberMissionId(memberMission.getId())
                    .createdAt(LocalDateTime.now())
                    .build();
    }

    public static MemberMissionResponseDTO.MemberMissionPreViewDTO toMemberMissionPreViewDTO(MemberMission memberMission) {

        return MemberMissionResponseDTO.MemberMissionPreViewDTO.builder()
                .memberMissionId(memberMission.getId())
                .missionCode(memberMission.getMissionCode())
                .missionStatus(memberMission.getMissionStatus())
                .missionId(memberMission.getMission().getId())
                .price(memberMission.getMission().getPrice())
                .point(memberMission.getMission().getPoint())
                .remainDate(memberMission.getMission().getRemainDate())
                .restaurantName(memberMission.getMission().getRestaurant().getName())
                .build();
    }

    public static MemberMissionResponseDTO.MemberMissionPreViewListDTO toMemberMissionPreViewListDTO(Page<MemberMission> memberMissionList) {

        List<MemberMissionResponseDTO.MemberMissionPreViewDTO> memberMissionPreViewDTOList = memberMissionList.stream()
                .map(MemberMissionConverter::toMemberMissionPreViewDTO)
                .collect(Collectors.toList());

        return MemberMissionResponseDTO.MemberMissionPreViewListDTO.builder()
                .isLast(memberMissionList.isLast())
                .isFirst(memberMissionList.isFirst())
                .totalPages(memberMissionList.getTotalPages())
                .totalElements(memberMissionList.getTotalElements())
                .listSize(memberMissionPreViewDTOList.size())
                .memberMissionList(memberMissionPreViewDTOList)
                .build();
    }
}
