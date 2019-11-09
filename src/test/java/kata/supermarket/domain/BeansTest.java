package kata.supermarket.domain;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class BeansTest {

private Beans beans;

 @Before
 public void setUp() throws Exception {
    beans = new Beans("Beans", new BigDecimal(0.50), 6);
 }
 @Test
 public void testBeansObject() throws Exception {
 assertNotNull(beans);
 assertEquals(new BigDecimal(0.50),beans.getPrice());
 assertEquals(6, beans.getQuantity());
 assertEquals("Beans", beans.getName());
 }


 }
