package the.best.entity;

import javax.persistence.*;

@Entity
public class Discount {
    @Id
    private String id;

    private double percent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}
