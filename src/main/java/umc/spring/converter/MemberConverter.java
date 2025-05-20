package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static Member toMember(MemberRequestDTO.JoinDto request){

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(request.getGender())
                .name(request.getName())
                .preferredFoodList(new ArrayList<>())

                .email(request.getEmail())
                .platform(request.getPlatform())
                .phoneNum(request.getPhoneNum())
                .birthdate(LocalDate.of(request.getBirthYear(), request.getBirthMonth(), request.getBirthDay()))
                .status(request.getStatus())
                .point(0)

                .build();
    }

}
