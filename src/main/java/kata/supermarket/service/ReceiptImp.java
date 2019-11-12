package kata.supermarket.service;

import kata.supermarket.domain.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class ReceiptImp implements Receipt {

   private int num = 0;
   private  Beans beans;
   private  BigDecimal price = new BigDecimal(BigInteger.valueOf(num), 2);

    @Override
    public void printReceipt() {
    }

    @Override
    public BigDecimal calculateTotalBeansPrice(String name, BigDecimal itemPrice, BigDecimal discount, int quantity) {

        if (name == null || name.equalsIgnoreCase(" ") ) {
            throw new RuntimeException("Name must be provided");
        }
        else if (itemPrice == null || itemPrice.compareTo(BigDecimal.valueOf(0.00)) == 0){
                throw new RuntimeException("Price must be provided and must be more than 0.00");
        }
        else if ( quantity == 0){
                   throw new RuntimeException("Quantity must be more than zero");
        }
        if (name.equalsIgnoreCase("Beans")){
            beans = new Beans("Beans",itemPrice  , quantity);
            price = getPriceOfUnitOIBeans(beans);
            price =    getPriceOfTwoUnitsOIBeans(beans);
            price = getPriceDivisibleByTreeAndRemainderOne(beans, discount);
            price = getPriceDivisibleByTreeAndRemainderOne(beans, discount);
            price = getPriceOfBeansDivisibleByThree(beans, discount);
        }
        return price.setScale(2,RoundingMode.DOWN);
    }

    public   BigDecimal getPriceOfUnitOIBeans(Beans beans){
        if (beans.getQuantity() == 1 ){
            price = beans.getPrice();
        }
        return price;
    }

    private  BigDecimal getPriceOfTwoUnitsOIBeans(Beans beans){
        if (beans.getQuantity() == 2 ){
            price = beans.getPrice().multiply(BigDecimal.valueOf(2.00));        }
        return price;
    }

    private   BigDecimal getPriceDivisibleByTreeAndRemainderOne(Beans beans, BigDecimal discount){
        if ( beans.getQuantity() > 3 &&    beans.getQuantity() % 3 == 1 ){
            int remainder = beans.getQuantity() % 3 ;
            int eligibleForDiscount = (beans.getQuantity() - remainder)  ;
            discount =  beans.getPrice().multiply(BigDecimal.valueOf(eligibleForDiscount)).multiply(new BigDecimal(String.valueOf(discount)));
            price = beans.getPrice().multiply(new BigDecimal(beans.getQuantity())).subtract(discount);
            price.add(new BigDecimal(0.50).multiply(new BigDecimal(remainder)));
        }
        return price;
    }

    private   BigDecimal getPriceDivisibleByThreeAndRemainderTwo(Beans beans, BigDecimal discount){
        if ( beans.getQuantity() > 3 &&    beans.getQuantity() % 3 == 2 ){
            int remainder = beans.getQuantity() % 3 ;
            int eligibleForDiscount = (beans.getQuantity() - remainder)  ;
            discount =  beans.getPrice().multiply(BigDecimal.valueOf(eligibleForDiscount)).multiply(new BigDecimal(String.valueOf(discount)));
            price = beans.getPrice().multiply(new BigDecimal(beans.getQuantity())).subtract(discount);
            price.add(new BigDecimal(0.50).multiply(new BigDecimal(remainder)));
        }
        return price;
    }

    private   BigDecimal getPriceOfBeansDivisibleByThree(Beans beans, BigDecimal discount){
        if (beans.getQuantity() % 3 == 0){
            discount =  beans.getPrice().multiply(BigDecimal.valueOf(beans.getQuantity())).multiply(new BigDecimal(String.valueOf(discount)));
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
           // System.out.println(" Price after oranges instantiation :" + orange.getPrice().setScale(2,RoundingMode.DOWN));
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

      //  BigDecimal payPrice3 = receipt.calculateTotalCokePrice("Coke", new BigDecimal(0.70 ), 24) ;
     //  System.out.println(payPrice3.setScale(2,RoundingMode.CEILING));

        }
}

