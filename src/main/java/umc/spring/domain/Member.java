package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "member")
public class Member {
    @PrePersist
    public void onCreate() {
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReviewPhoto> reviewPhotos = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PreferredFood> preferredFoodList = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", nullable = false)
    private Long id;

    @Column(name = "platform", length = 15)
    private String platform;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "name", length = 10)
    private String name;

    @Column(name = "gender", length = 10) // 남성/여성
    private String gender;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Lob
    @Column(name = "address")
    private String address;

    @Column(name = "spec_address")
    private String specAddress;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @ColumnDefault("'active'")
    @Column(name = "status", nullable = false, length = 15)
    private String status = "active";

    @Column(name = "inactive_date")
    private Instant inactiveDate;

    @Column(name = "phone_num")
    private Integer phoneNum;

    @ColumnDefault("0")
    @Column(name = "point", nullable = false)
//    @Builder.Default
    private Integer point = 0;


}