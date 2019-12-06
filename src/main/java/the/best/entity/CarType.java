package the.best.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="car_type")
@Getter
@Setter
public class CarType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type_name")
    private String typeName;

    @Column(name = "price_booking")
    private Double priceBooking;

    @Column(name = "price_per_km")
    private Double pricePerKm;

    private Integer capacity;

    @OneToMany(mappedBy = "carType")
    private List<Car> phones;
}
