package apparel;

import java.awt.*;

public class Sock {
    private String size;
    private String material;
    private Color color;
    private double price;
    private int ownedAge;
    private boolean containsHoles;
    private boolean isPaired;

    public Sock(String size, String material, Color color,
                double price, int ownedAge, boolean containsHoles,
                boolean isPaired) {
        this.size = size;
        this.material = material;
        this.color = color;
        this.price = price;
        this.ownedAge = ownedAge;
        this.containsHoles = containsHoles;
        this.isPaired = isPaired;
    }

    @Override
    public String toString() {
        return "Sock{" +
                "size='" + size + '\'' +
                ", material='" + material + '\'' +
                ", color=" + color +
                ", price=" + price +
                ", ownedAge=" + ownedAge +
                ", containsHoles=" + containsHoles +
                ", isPaired=" + isPaired +
                '}';
    }
}
