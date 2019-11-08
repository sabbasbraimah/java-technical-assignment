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
    /**
    @Test
    public void testNullObject() throws Exception {
        Receipt receipt  = new  ReceiptImp();

        BigDecimal price  = receipt.calculatePrice("Beans",new BigDecimal(0.50), new BigDecimal(0.33), 24 );
        System.out.println(price.setScale(2,RoundingMode.DOWN));


        System.out.println(price + " is ");
        assertNotNull(price);
       assertEquals(new BigDecimal(8.03).setScale(2,RoundingMode.UP), receipt.calculatePrice("Beans", new BigDecimal(0.50), new BigDecimal(0.33),24) );
       // assertEquals(1, beans.getQuantity());
       // assertEquals("Beans", beans.getName());
    }
**/
}
