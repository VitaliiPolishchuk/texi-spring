package the.best.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "car_name")
    private String carName;

    @Column(name = "photo_url")
    private String photoUrl;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="car_type_id")
    private CarType carType;


}
