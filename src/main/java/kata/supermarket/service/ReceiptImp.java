package kata.supermarket.service;

import kata.supermarket.domain.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * A<code>ReceiptImp</code>object representing a service for
 * printing the  total price of products bought by a customer
 *
 * @author S.B.A\bbas
 */
public class ReceiptImp implements Receipt {

   private int num = 0;
   private  Beans beans;
   private  PriceCalculator priceCalculator;

   private  BigDecimal price = new BigDecimal(BigInteger.valueOf(num), 2);

    public ReceiptImp() {
    }

    @Override
    public  void printTotalPrice(Beans beans, BigDecimal itemPrice, BigDecimal discount, int quantity ) {
        String name = beans.getName();
        beans = new Beans("Beans", itemPrice,quantity);
        priceCalculator = priceCalculatorFactory(beans.getQuantity());
        price = priceCalculator.calculateTotalPrice(beans.getName(), beans.getPrice(),discount,beans.getQuantity());
        String formattedBeansTotalPrice = String.format("  Total Price..........%.2f",
                price.setScale(2, RoundingMode.DOWN));
        System.out.println(formattedBeansTotalPrice);
    }

    public   PriceCalculator priceCalculatorFactory(int quantity){
        if (quantity == 1 || quantity == 2){
            priceCalculator = new PriceCalculatorForOneOrTwoBeansUnits();
        }
        else if (quantity > 3  && (quantity % 3 == 2) || quantity % 3 == 1)  {
            priceCalculator = new PriceCalculatorDiscountAndRemainder();
        }
        else if(quantity % 3 == 0){
            priceCalculator = new PriceCalculatorForBuyThreePayForTwo();

        }
        return priceCalculator;
    }
    public static  void main(String[] args){
        Receipt receipt = new ReceiptImp();
        Beans beans = new Beans("Beans,",new BigDecimal(0.40), 8);
        // testing the printTotalPrice() method.
        receipt. printTotalPrice(beans, beans.getPrice(),  new BigDecimal(0.33) , 8 );
    }
}

