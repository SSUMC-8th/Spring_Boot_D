package umc.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Coffee {
    @Id
    private String id;

    private String name;

    public Coffee() {}

    public Coffee(String id, String name) {
        this.id = id;
        this.name = name;
    }

}
