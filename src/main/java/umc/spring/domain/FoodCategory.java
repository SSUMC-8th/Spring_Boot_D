package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
//@Table(name = "food_category")
@Getter
//@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FoodCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "food_id")
    private Long id;

//    @Column(name = "name", nullable = false)
    private String name;
}
