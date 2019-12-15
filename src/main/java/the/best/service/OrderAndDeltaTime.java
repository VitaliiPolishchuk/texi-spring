package the.best.service;

import lombok.Getter;
import lombok.Setter;
import the.best.web.data.OrderData;

@Getter
@Setter
public class OrderAndDeltaTime implements Comparable<OrderAndDeltaTime> {
    private OrderData order;
    private int delta;

    public OrderAndDeltaTime(OrderData order, int delta) {
        this.order = order;
        this.delta = delta;
    }


    @Override
    public int compareTo(OrderAndDeltaTime o) {
        return Integer.compare(o.getDelta(), this.delta);
    }
}
