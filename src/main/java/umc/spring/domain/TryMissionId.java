package umc.spring.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class TryMissionId implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "try_mission_id", nullable = false)
    private Long tryMissionId;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "mission_id", nullable = false)
    private Long missionId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TryMissionId that = (TryMissionId) o;
        return Objects.equals(tryMissionId, that.tryMissionId)
                && Objects.equals(memberId, that.memberId)
                && Objects.equals(missionId, that.missionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tryMissionId, memberId, missionId);
    }
}
