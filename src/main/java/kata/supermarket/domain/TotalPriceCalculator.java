package kata.supermarket.domain;

import java.math.BigDecimal;

public interface TotalPriceCalculator {

    BigDecimal calculateTotalPrice(String name, BigDecimal itemPrice, BigDecimal discount, int quantity);
   // BigDecimal calculateTotalOrangePrice(String name,  BigDecimal itemPrice,  double weight);
   // BigDecimal calculateTotalCokePrice(String name, BigDecimal itemPrice, int quantity) ;

}
