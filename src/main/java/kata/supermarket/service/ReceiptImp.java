package kata.supermarket.service;

import kata.supermarket.domain.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class ReceiptImp implements Receipt {

   private int quantity = 3;

    @Override
    public void printReceipt() {

    }
    @Override
    public BigDecimal calculateTotalBeansPrice(String name, BigDecimal itemPrice, BigDecimal discount, int quantity) {

        int num = 0;
        BigDecimal price = new BigDecimal(BigInteger.valueOf(num), 2);
        if (name.equalsIgnoreCase("Beans")){
            Beans beans = new Beans("Beans",itemPrice  , quantity);
            if (beans.getQuantity() == 1 ){
                price = beans.getPrice();
            }
            if (beans.getQuantity() == 2 ){
                price = beans.getPrice().multiply(BigDecimal.valueOf(2.00));
            }
            if ( beans.getQuantity() > 3 &&    beans.getQuantity() % 3 == 1 ){
                int remainder = beans.getQuantity() % 3 ;
                int eligibleForDiscount = (beans.getQuantity() - remainder)  ;
                discount =  beans.getPrice().multiply(BigDecimal.valueOf(eligibleForDiscount)).multiply(new BigDecimal(String.valueOf(discount)));
                price = beans.getPrice().multiply(new BigDecimal(quantity)).subtract(discount);
                price.add(new BigDecimal(0.50).multiply(new BigDecimal(remainder)));
            }
            if ( beans.getQuantity() > 3 &&    beans.getQuantity() % 3 == 2 ){
                int remainder = beans.getQuantity() % 3 ;
                int eligibleForDiscount = (beans.getQuantity() - remainder)  ;
                discount =  beans.getPrice().multiply(BigDecimal.valueOf(eligibleForDiscount)).multiply(new BigDecimal(String.valueOf(discount)));
                price = beans.getPrice().multiply(new BigDecimal(quantity)).subtract(discount);
                price.add(new BigDecimal(0.50).multiply(new BigDecimal(remainder)));
            }
            if (beans.getQuantity() % 3 == 0){
                discount =  beans.getPrice().multiply(BigDecimal.valueOf(quantity)).multiply(new BigDecimal(String.valueOf(discount)));
                price = beans.getPrice().multiply(new BigDecimal(quantity)).subtract(discount);
            }
        }
        return price.setScale(2,RoundingMode.DOWN);

    }

    @Override
    public BigDecimal calculateTotalOrangePrice(String name, BigDecimal itemPrice, double weight) {
        return null;
    }

    @Override
    public BigDecimal calculateTotalCokePrice(String name, BigDecimal itemPrice, int quantity) {
        return null;
    }

    /**
    @Override
    public  BigDecimal calculateOrangePrice(String name, BigDecimal itemPrice,  double weight) {
        // 0.200 kg @  £1.99/kg 0.40
        int num = 0;
        BigDecimal price = new BigDecimal(BigInteger.valueOf(num), 2);

        if (name.equalsIgnoreCase("Orange")){
            Oranges orange = new Oranges("Orange",itemPrice  , weight);
           // System.out.println(" Price after oranges instantiation :" + orange.getPrice().setScale(2,RoundingMode.DOWN));
                price = orange.getPrice().multiply(BigDecimal.valueOf(orange.getWeight()/0.200));
        }

        return price.setScale(2,RoundingMode.DOWN);

    }

    @Override
    public BigDecimal calculateCokePrice(String name, BigDecimal itemPrice,  int quantity) {

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
               // System.out.println(coke.getQuantity() + "   :" + coke.getPrice().multiply(BigDecimal.valueOf(2)));
                price = coke.getPrice().multiply(BigDecimal.valueOf(2.00));
                BigDecimal discount = price.multiply(BigDecimal.valueOf(28.6).divide(BigDecimal.valueOf(100)));
                price = price.subtract(discount);
            }
        }         return price.setScale(2,RoundingMode.UP);
    }
    **/
    public static  void  main(String[] args ){
        Receipt receipt  = new  ReceiptImp();

       BigDecimal payPrice  = receipt.calculateTotalBeansPrice("Beans",new BigDecimal(0.50), new BigDecimal(0.33), 8 );
       System.out.println(payPrice.setScale(2,RoundingMode.DOWN));

     //  BigDecimal payPrice2 =   receipt. calculateOrangePrice("Orange", new BigDecimal(0.40),  0.200);
     //  System.out.println(payPrice2.setScale(2,RoundingMode.DOWN));



      //  BigDecimal payPrice3 = receipt.calculateCokePrice("Coke", new BigDecimal(0.70 ), 2) ;
      //  System.out.println(payPrice3.setScale(2,RoundingMode.CEILING));


        }
}

