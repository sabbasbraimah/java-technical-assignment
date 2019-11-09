package kata.supermarket.domain;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class OrangeTest {

    private Oranges orange;

    @Before
    public void setUp() throws Exception {
        orange = new Oranges("orange", new BigDecimal(0.28), 0.200);
    }
    @Test
    public void testOrangeObject() throws Exception {
        assertNotNull(orange);
        assertEquals(new BigDecimal(0.28),orange.getPrice());
        assertEquals(0.200, orange.getWeight(),0.1);
        assertEquals("orange", orange.getName());
    }

}
