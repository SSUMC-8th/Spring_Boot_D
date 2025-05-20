package umc.spring.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    @Column(name = "restaurant_name")
    private String restaurantName;

    @Column(name = "category")
    private String category;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OpenHour> openHours = new ArrayList<>();


    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", restaurantName='" + restaurantName + '\'' +
                ", category='" + category + '\'' +
                ", rating=" + rating +
                ", region=" + (region != null ? region.getAddress() : "N/A") +
                '}';
    }
}
