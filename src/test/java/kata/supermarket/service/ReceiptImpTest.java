package kata.supermarket.service;

import kata.supermarket.domain.Beans;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class ReceiptImpTest {

    Receipt receipt;
    Beans beans;

    @Before
    public void setUp() throws Exception {
        receipt = new ReceiptImp();
        beans = new Beans("Beans", new BigDecimal(0.40), 8);
    }

    @Test
    public void testPrintTotalPrice() throws Exception {

        receipt.printTotalPrice(beans, beans.getPrice(), new BigDecimal(0.33), beans.getQuantity() ) ;

        }
}
