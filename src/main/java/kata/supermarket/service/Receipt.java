package kata.supermarket.service;

import kata.supermarket.domain.Beans;
import kata.supermarket.domain.Item;
import kata.supermarket.domain.Product;

import java.math.BigDecimal;

public interface Receipt {

    void printTotalPrice(Beans beans, BigDecimal itemPrice, BigDecimal discount, int quantity ) ;

    }
