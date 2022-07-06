/**
 *  Author: Cesar Escalona
 *  SDEV301 Systems Programming
 *  This class represents a card in the Set card game
 */

package cards;

public class SetCard extends Card{
    private String shape;
    private int number;
    private String shading;
    private String color;

    public SetCard(String shape, int number, String shading, String color) {
        super(shading + " - " + color + " " + shape + " " + number);
        this.shape = shape;
        this.number = number;
        this.shading = shading;
        this.color = color;
    }

    public String getShape(){
        return shape;
    }

    public int getNumber() {
        return number;
    }

    public String getShading() {
        return shading;
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        return super.toString();
    }
}
