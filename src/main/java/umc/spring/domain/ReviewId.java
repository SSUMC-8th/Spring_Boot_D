package umc.spring.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class ReviewId implements Serializable {

    private static final long serialVersionUID = -2732520101918331065L;

    @Column(name = "review_id", nullable = false)
    private Long reviewId;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "restaurant_id", nullable = false)
    private Long restaurantId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ReviewId entity = (ReviewId) o;
        return Objects.equals(reviewId, entity.reviewId)
                && Objects.equals(memberId, entity.memberId)
                && Objects.equals(restaurantId, entity.restaurantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, memberId, restaurantId);
    }
}
