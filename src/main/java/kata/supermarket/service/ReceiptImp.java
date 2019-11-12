package kata.supermarket.service;

import kata.supermarket.domain.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * A<code>Receipt</code>object representing a service of
 * calculating total of products bought and printing the total price
 * for all customer's purchase
 * @author S.B.A\bbas
 */
public class ReceiptImp implements Receipt {

   private int num = 0;
   private  Beans beans;
   private  BigDecimal price = new BigDecimal(BigInteger.valueOf(num), 2);

    @Override
    public void printReceipt() {
    }

    /**
     * Calculates the total price of unit(s) of Beans bought.
     * @param name the name of the product which in this case is Beans.
     * @param itemPrice the price of a unit of Beans which is aof type BigDecimal(cale to 2, eg. 0.40)
     * @param discount  the discount if units bought are more than three.
     * @param quantity the number of units bought such as 1,2,3,etc.
     * @return the total price of the quantity and if discount is applicable
     */
    @Override
    public BigDecimal calculateTotalBeansPrice(String name, BigDecimal itemPrice,
                                               BigDecimal discount, int quantity) {

        /**
         * The next three conditional blocks below are used to
         * Check that no wrong input  is entered and notify user if there is any.
         */
        if (name == null || name.equalsIgnoreCase(" ") ) {
            throw new IllegalArgumentException("Name must be provided");//
        }
        else if (itemPrice == null || itemPrice.compareTo(BigDecimal.valueOf(0.00)) == 0){
                throw new IllegalArgumentException("Price must be provided and must be more than 0.00");
        }
        else if ( quantity == 0){
                   throw new IllegalArgumentException("Quantity must be more than zero");
        }
        if (name.equalsIgnoreCase("Beans")){
            beans = new Beans("Beans",itemPrice  , quantity);
            price = getPriceOfUnitOfBeans(beans);
            price =    getPriceOfTwoUnitsOIBeans(beans);
            price = getPriceDivisibleByThreeAndRemainderOne(beans, discount);
            price = getPriceDivisibleByThreeAndRemainderOne(beans, discount);
            price = getPriceOfBeansDivisibleByThree(beans, discount);
        }
        return price.setScale(2,RoundingMode.DOWN);
    }

    /**
     * Calculates the price of a single unit of Beansd
     * @param beans the Bean object tp extract a single price from
     * @return the price of a single unit of Beans
     */
    private   BigDecimal getPriceOfUnitOfBeans(Beans beans){
        if (beans.getQuantity() == 1 ){
            price = beans.getPrice();
        }
        return price;
    }

    /**
     * Calculates the price of two units of Beans
     * @param beans the Bean object tp extract a single price from
     * @return the total price of two units of Beans
     */
    private  BigDecimal getPriceOfTwoUnitsOIBeans(Beans beans){
        if (beans.getQuantity() == 2 ){
            price = beans.getPrice().multiply(BigDecimal.valueOf(2.00));
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
            int remainder = beans.getQuantity() % 3 ;
            int eligibleForDiscount = (beans.getQuantity() - remainder)  ;
            discount =  beans.getPrice().multiply(BigDecimal.valueOf(eligibleForDiscount))
                    .multiply(new BigDecimal(String.valueOf(discount)));
            price = beans.getPrice().multiply(new BigDecimal(beans.getQuantity())).subtract(discount);
            price.add(new BigDecimal(0.50).multiply(new BigDecimal(remainder)));
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
            int remainder = beans.getQuantity() % 3 ;
            int eligibleForDiscount = (beans.getQuantity() - remainder)  ;
            discount =  beans.getPrice().multiply(BigDecimal.valueOf(eligibleForDiscount))
                    .multiply(new BigDecimal(String.valueOf(discount)));
            price = beans.getPrice().multiply(new BigDecimal(beans.getQuantity())).subtract(discount);
            price.add(new BigDecimal(0.50).multiply(new BigDecimal(remainder)));
        }
        return price;
    }

    private   BigDecimal getPriceOfBeansDivisibleByThree(Beans beans, BigDecimal discount){
        if (beans.getQuantity() % 3 == 0){
            discount =  beans.getPrice().multiply(BigDecimal.valueOf(beans.getQuantity()))
                    .multiply(new BigDecimal(String.valueOf(discount)));
            price = beans.getPrice().multiply(new BigDecimal(beans.getQuantity())).subtract(discount);
        }
        return price;
    }

    @Override
    public  BigDecimal calculateTotalOrangePrice(String name, BigDecimal itemPrice,  double weight) {
        // 0.200 kg @  £1.99/kg 0.40
        int num = 0;
        BigDecimal price = new BigDecimal(BigInteger.valueOf(num), 2);

        if (name.equalsIgnoreCase("Orange")){
            Oranges orange = new Oranges("Orange",itemPrice  , weight);
                price = orange.getPrice().multiply(BigDecimal.valueOf(orange.getWeight()/0.200));
        }
        return price.setScale(2,RoundingMode.DOWN);
    }

    @Override
    public BigDecimal calculateTotalCokePrice(String name, BigDecimal itemPrice,  int quantity) {

        int num = 0;
        BigDecimal price = new BigDecimal(BigInteger.valueOf(num), 2);
        if (name.equalsIgnoreCase("Coke")) {
            Coke coke = new Coke("coke", itemPrice, quantity);
           // System.out.println(" Price after coke instantiation :" + coke.getPrice());
            if (coke.getQuantity() == 1) {
               // System.out.println(coke.getQuantity() + "   :" + coke.getPrice());
                price = coke.getPrice();
            }
            if (coke.getQuantity() % 2 == 0) {
                price = new BigDecimal(coke.getQuantity()/3);
            }
        }
        return price.setScale(2,RoundingMode.UP);
    }

    public static  void  main(String[] args ){


        Receipt receipt  = new  ReceiptImp();

       BigDecimal payPrice  = receipt.calculateTotalBeansPrice("Beans",new BigDecimal(0.50), new BigDecimal(0.33), 8 );
       System.out.println(payPrice.setScale(2,RoundingMode.DOWN));

       BigDecimal payPrice2 =   receipt. calculateTotalOrangePrice("Orange", new BigDecimal(0.40),  0.200);
       System.out.println(payPrice2.setScale(2,RoundingMode.DOWN));

        BigDecimal payPrice3 = receipt.calculateTotalCokePrice("Coke", new BigDecimal(0.70 ), 24) ;
       System.out.println(payPrice3.setScale(2,RoundingMode.CEILING));

        }
}

