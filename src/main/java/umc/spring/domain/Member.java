package umc.spring.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", nullable = false)
    private Long id;

    @Column(name = "platform", length = 15)
    private String platform;

    @Column(name = "email", length = 10)
    private String email;

    @Column(name = "name", length = 10)
    private String name;

    @Column(name = "gender", length = 10)
    private String gender;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Lob
    @Column(name = "address")
    private String address;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @ColumnDefault("'active'")
    @Column(name = "status", nullable = false, length = 15)
    private String status;

    @Column(name = "inactive_date")
    private Instant inactiveDate;

    @Column(name = "phone_num")
    private Integer phoneNum;

    @ColumnDefault("0")
    @Column(name = "point", nullable = false)
    private Integer point;

}