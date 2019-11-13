package kata.supermarket.domain;

import java.math.BigDecimal;


/**
 * A<code>PriceCalculatorForOneOrTwoBeansUnits</code>object representing a service of
 * calculating total price of one or two units
 * @author S.B.A\bbas
 */

public class PriceCalculatorForOneOrTwoBeansUnits extends PriceCalculator{

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
        if (name == null || name.length() < 1) {
            throw new IllegalArgumentException("Name must be provided");//
        } else if (itemPrice == null || itemPrice.compareTo(BigDecimal.valueOf(0.00)) == 0) {
            throw new IllegalArgumentException("Price must be provided and must be more than 0.00");
        } else if (quantity == 0) {
            throw new IllegalArgumentException("Quantity must be more than zero");
        }
        if (name.equalsIgnoreCase("Beans")) {
            beans = new Beans("Beans", itemPrice, quantity);
            if (beans.getQuantity() == 1 || beans.getQuantity() == 2) {
                price = getPriceOfUnitOfBeans(beans);
                System.out.println("1 : " + price);
            }
        }
        return price;
    }
    /**
     * Calculates the price of a single unit of Beansd
     * @param beans the Bean object tp extract a single price from
     * @return the price of a single unit of Beans
     */
    private   BigDecimal getPriceOfUnitOfBeans(Beans beans){
        if (beans.getQuantity() == 1 || beans.getQuantity() == 2){
            price = beans.getPrice().multiply(new BigDecimal(beans.getQuantity()));
        }
        return price;
    }

}
