package umc.spring.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class MissionId implements java.io.Serializable {
    private static final long serialVersionUID = -3993916424914147097L;
    @Column(name = "mission_id", nullable = false)
    private Long missionId;

    @Column(name = "restaurant_id", nullable = false)
    private Long restaurantId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MissionId entity = (MissionId) o;
        return Objects.equals(this.missionId, entity.missionId) &&
                Objects.equals(this.restaurantId, entity.restaurantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(missionId, restaurantId);
    }

}