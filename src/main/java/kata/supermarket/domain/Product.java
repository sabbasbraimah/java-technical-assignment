package kata.supermarket.domain;

import java.math.BigDecimal;


/**
 Product –  product is the abstract class
 that specific products such as Beans, etc. inherit from
 @author S.B.Abbas
 */

public abstract class Product implements Item{

    private String name;
    private BigDecimal price;

    public Product() {
    }

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public BigDecimal getPrice() {
        return price;
    }
}
