package umc.spring.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "table_demo")
public class DemoEntity {
        @Id
        @GeneratedValue
        private Long id;
        private String demoText;
}
