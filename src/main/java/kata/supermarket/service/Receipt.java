package kata.supermarket.service;

import kata.supermarket.domain.Item;
import kata.supermarket.domain.Product;

import java.math.BigDecimal;

public interface Receipt {

    void printReceipt();
    BigDecimal calculateTotalBeansPrice(String name,  BigDecimal itemPrice, BigDecimal discount , int quantity);
    BigDecimal calculateTotalOrangePrice(String name,  BigDecimal itemPrice,  double weight);
    BigDecimal calculateTotalCokePrice(String name, BigDecimal itemPrice, int quantity) ;

    }
