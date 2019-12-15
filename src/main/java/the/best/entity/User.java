package the.best.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class User {
    @Id
    private String email;
    private String firstName;
    private String lastName;
    private String emailPassword;

    @Column(name = "user_points")
    private int userPoints;
}
