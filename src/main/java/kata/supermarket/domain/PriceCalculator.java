package kata.supermarket.domain;

import java.math.BigDecimal;

public  abstract class PriceCalculator implements TotalPriceCalculator{

    public abstract BigDecimal calculateTotalPrice(String name, BigDecimal itemPrice, BigDecimal discount, int quantity) ;

}
