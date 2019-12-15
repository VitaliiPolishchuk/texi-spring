package the.best.pattern;

import org.junit.Before;
import org.junit.Test;
import the.best.entity.CarType;
import the.best.entity.Discount;
import the.best.web.data.OrderData;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class KmPriceCalculationServiceTest {

    KmPriceCalculationService instance;

    @Before
    public void setUp() {
        instance = new KmPriceCalculationService();
    }

    @Test
    public void shouldBe10DiscountPriceWhenTimeIs600(){
        CarType carType = new CarType();
        OrderData orderData = new OrderData();
        orderData.setTimeToReachDestination(700);
        orderData.setTimeToReachOrigin(100);

        instance.calculate(orderData, null, null);
        assertEquals(10.0, orderData.getDiscountPrice(), 0.01);
    }

    @Test
    public void shouldBe10WholePriceWhenTimeIs600(){
        CarType carType = new CarType();
        OrderData orderData = new OrderData();
        orderData.setTimeToReachDestination(700);
        orderData.setTimeToReachOrigin(100);

        instance.calculate(orderData, null, null);
        assertEquals(10.0, orderData.getWholePrice(), 0.01);
    }
}