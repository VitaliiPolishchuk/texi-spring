package the.best.web.data;

import lombok.Getter;
import lombok.Setter;
import the.best.entity.Car;
import the.best.entity.CarType;
import the.best.web.data.builder.OrderBuilder;

import java.time.LocalTime;

@Getter
@Setter
public class Order {
    private CarType carType;
    private Car car;
    private Location origin;
    private Location destination;
    private int timeToReachDestination;
    private int timeToReachOrigin;
    private double wholePrice = 0;
    private double discountPrice = 0;
    private boolean isDiscount;
    private boolean isUserPoints;

    public Order(OrderBuilder orderBuilder) {
        this.carType = orderBuilder.getCarType();
        this.car = orderBuilder.getCar();
        this.origin = orderBuilder.getOrigin();
        this.destination = orderBuilder.getDestination();
        this.timeToReachDestination = orderBuilder.getTimeToReachDestination();
        this.timeToReachOrigin = orderBuilder.getTimeToReachOrigin();
        this.wholePrice = orderBuilder.getWholePrice();
        this.discountPrice = orderBuilder.getDiscountPrice();
    }

    public int convertIntoMinutesTimeToReachOrigin(){
        System.out.println(timeToReachOrigin);
        return timeToReachOrigin / 60 + 1;
    }

    public String buildStringTimeToReachDestination(){
        LocalTime localTime = LocalTime.now();
        localTime = localTime.plusSeconds(timeToReachDestination);
        return new StringBuilder().append(localTime.getHour()).append(":").append(localTime.getMinute()).toString();
    }

    public int updatePrice(int price){
        return (int) price;
    }
}
