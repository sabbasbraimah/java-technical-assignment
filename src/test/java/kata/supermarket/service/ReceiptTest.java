package kata.supermarket.service;
import kata.supermarket.domain.Beans;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;




public class ReceiptTest {

    private Receipt receipt;

    @Before
    public void setUp() throws Exception {
        receipt = new ReceiptImp();
    }
    @Test
    public void testCalculateTotalBeansPrice() throws Exception {
        BigDecimal price  = receipt.calculateTotalBeansPrice("Beans",new BigDecimal(0.50), new BigDecimal(0.33), 24 );
        System.out.println(price.setScale(2,RoundingMode.DOWN));

        assertNotNull(price);
        assertEquals(price.setScale(2,RoundingMode.UP), receipt.calculateTotalBeansPrice("Beans", new BigDecimal(0.50), new BigDecimal(0.33),24 ) ) ;
    }







    @Test
    public void testCalculateTotalCokePrice() throws Exception {
        BigDecimal price  = receipt.calculateTotalCokePrice("Coke",new BigDecimal(0.70), 24 );
        System.out.println(price.setScale(2,RoundingMode.DOWN));
        assertNotNull(price);
        assertEquals(price.setScale(2,RoundingMode.UP), receipt.calculateTotalCokePrice("Coke",new BigDecimal(0.70), 24 ));
    }

    @Test
    public void testCalculateTotalOrangePrice() throws Exception {
        BigDecimal price  = receipt.calculateTotalOrangePrice("Orange",new BigDecimal(0.40), 0.200 );
        System.out.println(price.setScale(2,RoundingMode.DOWN) );
        assertNotNull(price);
        assertEquals( price.setScale(2,RoundingMode.UP), receipt.calculateTotalOrangePrice("Orange",new BigDecimal(0.40), 0.200));
    }

}
