package apparel;

import java.awt.*;

public class SockBuilder {
    private String size;
    private String material;
    private Color color;
    private double price;
    private int ownedAge;
    private boolean containsHoles;
    private boolean isPaired;

    public SockBuilder(){
        // do nothing
    }

    public SockBuilder setSize(String size) {
        this.size = size;
        return this;
    }

    public SockBuilder setMaterial(String material) {
        this.material = material;
        return this;
    }

    public SockBuilder setColor(Color color) {
        this.color = color;
        return this;
    }

    public SockBuilder price(double price) {
        this.price = price;
        return this;
    }

    public SockBuilder ownedAge(int ownedAge) {
        this.ownedAge = ownedAge;
        return this;
    }

    public SockBuilder containsHoles(boolean containsHoles) {
        this.containsHoles = containsHoles;
        return this;
    }

    public SockBuilder paired(boolean paired) {
        isPaired = paired;
        return this;
    }

    public Sock assemble() {
        // the builder helps assemble using the complex constructor
        return new Sock(size, material, color, price, ownedAge, containsHoles, isPaired);
    }
}
