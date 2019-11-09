package kata.supermarket.domain;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CokeTest {

    private Coke coke;

    @Before
    public void setUp() throws Exception {
        coke = new Coke("coke", new BigDecimal(0.70), 6);
    }
    @Test
    public void testCokeObject() throws Exception {
        assertNotNull(coke);
        assertEquals(new BigDecimal(0.70),coke.getPrice());
        assertEquals(6, coke.getQuantity());
        assertEquals("coke", coke.getName());
    }
    
}
