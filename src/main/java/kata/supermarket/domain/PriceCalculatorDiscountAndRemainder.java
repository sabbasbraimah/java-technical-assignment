package kata.supermarket.domain;

import java.math.BigDecimal;

/**
 * A<code>PriceCalculatorDiscountAndRemainder</code>object representing a service of
 * calculating total price cof discountable quantitu plus non discountable units
 * @author S.B.A\bbas
 */
public class PriceCalculatorDiscountAndRemainder extends PriceCalculator{


    private Beans beans;
    private BigDecimal price;

    /**
     * Calculates the total price of unit(s) of Beans bought.
     * @param name the name of the product which in this case is Beans.
     * @param itemPrice the price of a unit of Beans which is aof type BigDecimal(cale to 2, eg. 0.40)
     * @param discount  the discount if units bought are more than three.
     * @param quantity the number of units bought such as 1,2,3,etc.
     * @return the total price of the quantity and if discount is applicable
     */
    @Override
    public BigDecimal calculateTotalPrice(String name, BigDecimal itemPrice, BigDecimal discount, int quantity) {
        /**
         * The next three conditional blocks below are used to
         * Check that no wrong input  is entered and notify user if there is any.
         */
    /**
     * The next three conditional blocks below are used to
     * Check that no wrong input  is entered and notify user if there is any.
     */
        if (name == null || name.length() < 1) {
        throw new IllegalArgumentException("Name must be provided");//
    } else if (itemPrice == null || itemPrice.compareTo(BigDecimal.valueOf(0.00)) == 0) {
        throw new IllegalArgumentException("Price must be provided and must be more than 0.00");
    } else if (quantity == 0) {
        throw new IllegalArgumentException("Quantity must be more than zero");
    }
        if (name.equalsIgnoreCase("Beans")) {
        beans = new Beans("Beans", itemPrice, quantity);
        if ( beans.getQuantity() > 3 &&   ( beans.getQuantity() % 3 == 2 ) || beans.getQuantity() % 3 == 1){
            if ( beans.getQuantity() % 3 == 2 ) {
                price = getPriceDivisibleByThreeAndRemainderTwo(beans, discount);
            }
            else {
                price = getPriceDivisibleByThreeAndRemainderOne(beans, discount);
            }
            System.out.println("Remainder 1 : " + price);
        }
    }
        return price;
}

    /**
     * Calculates the price of quantity divisible by three
     * with a remainder two of Beans purchase.
     * @param beans the Bean object to extract a single price from
     * @return the total price of quantity  divisible by three with
     * a remainder two
     */
    private   BigDecimal getPriceDivisibleByThreeAndRemainderTwo(Beans beans, BigDecimal discount){
        if ( beans.getQuantity() > 3 &&    beans.getQuantity() % 3 == 2 ){
            int eligibleForDiscount =  (beans.getQuantity() )  -  ( beans.getQuantity() % 3 ) ;
            int discountQuantity =  eligibleForDiscount / 3;
            BigDecimal remainderPrice = new BigDecimal(String.valueOf(beans.getQuantity() % 3)).multiply(new BigDecimal(0.40));
            price = new BigDecimal(discountQuantity).add(remainderPrice);
        }
        return price;
    }

    /**
     * Calculates the price of quantity divisible by three
     * with a remainder of one of Beans purchase
     * @param beans the Bean object to extract a single price from
     * @return the total price of quantity  divisible by three with
     * a remainder one
     */
    private   BigDecimal getPriceDivisibleByThreeAndRemainderOne(Beans beans, BigDecimal discount){
        if ( beans.getQuantity() > 3 &&    beans.getQuantity() % 3 == 1 ){
            int dividedByThree = (beans.getQuantity() - beans.getQuantity() % 3 ) / 3;
            BigDecimal discountValue =  new BigDecimal(dividedByThree ).multiply(new BigDecimal(1.00));
            BigDecimal remainderPrice = beans.getPrice().multiply(new BigDecimal( beans.getQuantity() % 3 ));
            price = remainderPrice.add(discountValue);
        }
        return price;
    }


}
