package kata.supermarket.domain;

import java.math.BigDecimal;
import java.util.Objects;


/**
 A <code>Beans</code>object represents a product item
 that we sell to customers by a unit or a set of units.
 A Beans has a name, quantity, and a value.
 @author S.B.Abbas
 */
public class Beans extends Product {

    /**
     * The Beans quantity
     */
    private int quantity;
    /**
     * The Beans unit price
     */
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