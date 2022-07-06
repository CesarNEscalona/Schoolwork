package factory_methods;

import java.util.Random;

public class Color {
    //components will be in the range [0,255]
    private int red;
    private int green;
    private int blue;

    //this will always lie between [0, 1]
    //where 0 means transparent and 1 opaque
    private double alpha;

    private Color(int red, int green, int blue,
                 double alpha)
    {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    // add 3 factory methods that assembles Color objects for you
    public static Color blackLight(){
        return new Color(
                167, 0, 255, 100
        );
    }

    public static Color random(){
        Random random = new Random();
        return new Color(
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256),
                1.0
        );
    }

    public static Color magenta(){
        return new Color(
                255, 0, 255, 100
        );
    }

    public int getRed()
    {
        return red;
    }

    public int getGreen()
    {
        return green;
    }

    public int getBlue()
    {
        return blue;
    }

    public double getAlpha()
    {
        return alpha;
    }

    @Override
    public String toString()
    {
        return "(" + red + "," + green + "," + blue + "," +
                ((int) ((alpha / 1.0) * 100)) + "%)";
    }
}
