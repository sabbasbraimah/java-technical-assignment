package kata.supermarket.domain;

import java.math.BigDecimal;
import java.util.Objects;


/**
 Coke – A coke is a product item
 that we sell to customers by a unit pr a set of units

 @author S.B.Abbas
 */

public class Coke extends Product{

    private int quantity;

    public Coke() {
        super();
    }

    public Coke(String name, BigDecimal price, int quantity) {
        super(name, price);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
