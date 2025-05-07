package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.mapping.MemberAgree;
import umc.spring.domain.mapping.MemberPrefer;
import umc.spring.domain.mapping.MemberMission;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 10)
    private String gender;

    private Integer age;

    @Column(length = 40)
    private String address;

    @Column(name = "spec_address", length = 43)
    private String specAddress;

    @Column(length = 15)
    private String status;

    private LocalDateTime inactiveDate;

    @Column(length = 10)
    private String socialType;

    @Column(length = 50)
    private String email;

    private Integer point;

    @OneToMany(mappedBy = "member")
    @Builder.Default
    private List<MemberAgree> memberAgrees = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    @Builder.Default
    private List<MemberPrefer> memberPrefers = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    @Builder.Default
    private List<MemberMission> memberMissions = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    @Builder.Default
    private List<Review> reviews = new ArrayList<>();
}