package umc.spring.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "terms")
public class Term {
    @Id
    @Column(name = "terms_id", nullable = false)
    private Long id;

    @Column(name = "content")
    private String content;

    @ColumnDefault("0")
    @Column(name = "is_mandatory")
    private Integer isMandatory;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}