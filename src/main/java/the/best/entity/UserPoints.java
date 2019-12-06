package the.best.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_points")
@Getter
@Setter
public class UserPoints {
    @Id
    @Column(name = "user_email")
    private String userEmail;

    private Integer amount;
}
