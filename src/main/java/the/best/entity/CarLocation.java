package the.best.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="car_location")
@Getter
@Setter
public class CarLocation {
    @Id
    @Column(name = "car_id")
    private Integer carId;

    @Column(name = "location_id")
    private String locationId;
}
