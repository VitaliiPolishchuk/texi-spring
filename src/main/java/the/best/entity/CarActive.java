package the.best.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="car_active")
@Getter
@Setter
public class CarActive {
    @Id
    @Column(name = "car_id")
    private Integer carId;
}
