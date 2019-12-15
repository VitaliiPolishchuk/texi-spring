package the.best.pattern;

import org.junit.Before;
import org.junit.Test;
import the.best.entity.CarType;
import the.best.entity.User;
import the.best.web.data.OrderData;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class UserPointsPriceCalculationServiceTest {
    UserPointsPriceCalculationService instance;

    @Before
    public void setUp() {
        instance = new UserPointsPriceCalculationService();
    }



    @Test
    public void shouldBe90DiscountPriceWhenWholePriceIs100AndIsUserPoints(){
        OrderData orderData = new OrderData();
        orderData.setWholePrice(100);
        orderData.setDiscountPrice(100);
        User user = new User();
        user.setUserPoints(100);

        instance.calculate(orderData, user, null);
        assertEquals(90.0, orderData.getDiscountPrice(), 0.01);
    }

    @Test
    public void shouldBe100WholePriceWhenWholePriceIs100AndIsUserPoints(){
        OrderData orderData = new OrderData();
        orderData.setWholePrice(100);
        orderData.setDiscountPrice(100);
        User user = new User();
        user.setUserPoints(100);

        instance.calculate(orderData, user, null);
        assertEquals(100.0, orderData.getWholePrice(), 0.01);
    }

    @Test
    public void shouldReturnTrueWhenWholePriceIs100AndIsUserPoints(){
        OrderData orderData = new OrderData();
        orderData.setWholePrice(100);
        orderData.setDiscountPrice(100);
        User user = new User();
        user.setUserPoints(100);

        instance.calculate(orderData, user, null);
        assertTrue(orderData.isUserPoints());
    }

    @Test
    public void shouldBe100DiscountPriceWhenWholePriceIs100(){
        OrderData orderData = new OrderData();
        orderData.setWholePrice(100);
        orderData.setDiscountPrice(100);
        User user = new User();
        user.setUserPoints(100);

        instance.calculate(orderData, user, null);
        assertEquals(90.0, orderData.getDiscountPrice(), 0.01);
    }

    @Test
    public void shouldBe100WholePriceWhenWholePriceIs100(){
        OrderData orderData = new OrderData();
        orderData.setWholePrice(100);
        orderData.setDiscountPrice(100);
        User user = new User();
        user.setUserPoints(100);

        instance.calculate(orderData, user, null);
        assertEquals(100.0, orderData.getWholePrice(), 0.01);
    }

    @Test
    public void shouldReturnTrueWhenWholePriceIs100(){
        OrderData orderData = new OrderData();
        orderData.setWholePrice(100);
        orderData.setDiscountPrice(100);
        User user = new User();
        user.setUserPoints(100);

        instance.calculate(orderData, user, null);
        assertTrue(orderData.isUserPoints());
    }

}