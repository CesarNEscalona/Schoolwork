import java.awt.Color;

public class Marker
{
    private Color color;
    private String brand;
    
    // constructor - pass in color and brand
    public Marker(Color c, String b)
    {
       color = c;
       brand = b;
    }
    
    // getter for Color
    public Color getColor()
    {
       return color;
    }
    
    public String getBrand()
    {
        return brand;
    }
    
    // setter
    public void setColor(Color c)
    {
       color = c;
    }
    
    public void setBrand(String b)
    {
       brand = b;
    }

    public static void main(String[] args)
    {
        // Construct a Marker object
        Marker marker1 = new Marker(Color.BLUE,"Crayola");
        // toString() for the Object class
        System.out.println(marker1);
    }
}