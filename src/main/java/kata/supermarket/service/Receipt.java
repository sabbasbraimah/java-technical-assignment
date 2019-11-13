package kata.supermarket.service;

import kata.supermarket.domain.Beans;
/**
 * Receipt interface that prints the
 * total price.
 * It also serves the purpose being
 * the tool that makes it possible to
 * extend the print total price functionality
 * whenever a new different pricing system
 * is needed. You only need to implement a
 * new Receipt implementation for the needed feature.
 * @author S.B Abbas
 */

import java.math.BigDecimal;

public interface Receipt {

    void printTotalPrice(Beans beans, BigDecimal itemPrice, BigDecimal discount, int quantity ) ;

    }
