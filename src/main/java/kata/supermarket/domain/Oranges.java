package kata.supermarket.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Oranges extends Product{

    private double weight;

    public Oranges() {
        super();
    }

    public Oranges(String name, BigDecimal price, double weight) {
        super(name, price);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
