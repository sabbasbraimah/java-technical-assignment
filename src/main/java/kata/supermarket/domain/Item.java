package kata.supermarket.domain;

import java.math.BigDecimal;

/**
 Item –  item is the interface
 that specifies the most relevant
 functionality common tp all products
 @author S.B.Abbas
 */
public interface Item {

    public String getName();
    public BigDecimal getPrice();
}
