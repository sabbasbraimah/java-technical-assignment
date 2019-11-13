package kata.supermarket.service;
import kata.supermarket.domain.PriceCalculator;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;




public class TotalPriceCalculatorTest {

    private ReceiptImp receiptImp;
    private PriceCalculator priceCalculator;

    @Before
    public void setUp() throws Exception {
        this.receiptImp = new ReceiptImp();
    }
    @Test
    public void testCalculateTotalBeansPriceForOneOrTwoUnits() throws Exception {
        priceCalculator = receiptImp.priceCalculatorFactory(2);
        BigDecimal price  = priceCalculator.calculateTotalPrice("Beans",new BigDecimal(0.40), new BigDecimal(0.33), 2);
        System.out.println(price.setScale(2,RoundingMode.DOWN));

        assertNotNull(receiptImp);
        assertNotNull(priceCalculator);
        assertNotNull(price);
        assertEquals(price.setScale(2,RoundingMode.DOWN), priceCalculator.calculateTotalPrice("Beans",
                new BigDecimal(0.40), new BigDecimal(0.33),2)
                        .setScale(2,RoundingMode.DOWN)) ;
    }

    @Test
    public void testCalculateTotalBeansPricePayTwoForThree() throws Exception {
        priceCalculator = receiptImp.priceCalculatorFactory(3);
        BigDecimal price  = priceCalculator.calculateTotalPrice("Beans",new BigDecimal(0.40), new BigDecimal(0.33), 3);
        System.out.println(price.setScale(2,RoundingMode.DOWN));

        assertNotNull(receiptImp);
        assertNotNull(priceCalculator);
        assertNotNull(price);
        assertEquals(price.setScale(2,RoundingMode.DOWN), priceCalculator.calculateTotalPrice("Beans",
                new BigDecimal(0.40), new BigDecimal(0.33),3 )
                .setScale(2,RoundingMode.DOWN)) ;
    }

    @Test
    public void testCalculateTotalBeansPriceDiscountAndRemainder() throws Exception {
        priceCalculator = receiptImp.priceCalculatorFactory(5);
        BigDecimal price  = priceCalculator.calculateTotalPrice("Beans",new BigDecimal(0.40),
                new BigDecimal(0.33), 5);
        System.out.println(price.setScale(2,RoundingMode.DOWN));

        assertNotNull(receiptImp);
        assertNotNull(priceCalculator);
        assertNotNull(price);
        assertEquals(price.setScale(2,RoundingMode.DOWN), priceCalculator.calculateTotalPrice("Beans",
                new BigDecimal(0.40), new BigDecimal(0.33),5)
                .setScale(2,RoundingMode.DOWN)) ;
    }



}
