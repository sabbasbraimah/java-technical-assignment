package kata.supermarket.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Beans extends Product {


    private int quantity;
    private BigDecimal price;


    public Beans() {
        super();
    }

    public Beans(String name, BigDecimal price, int quantity) {
        super(name, price);
        this.quantity = quantity;
    }

    public BigDecimal getPrice(){
        return super.getPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}