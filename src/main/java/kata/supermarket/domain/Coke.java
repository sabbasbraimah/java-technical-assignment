package kata.supermarket.domain;

import java.math.BigDecimal;
import java.util.Objects;

/**
 A <code>Coke</code>object represents a product item
 that we sell to customers by a unit or a set of units.
 A BCoke has a name, quantity, and a value.
 @author S.B.Abbas
 */

public class Coke extends Product{

    /**
     * The Coke's quantity
     */
    private int quantity;
    /**
     * The Coke's unit price
     */
    private BigDecimal price;

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
