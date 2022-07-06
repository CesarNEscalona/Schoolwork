package clothes;

public class Clothes/* implements Comparable<Clothes>*/
{
    private String material;
    private String type;
    private int size;
    private double price;

    public Clothes(String material, String type,
                   int size, double price)
    {
        this.material = material;
        this.type = type;
        this.size = size;
        this.price = price;
    }

/*    @Override
    public int compareTo(Clothes other)
    {
        if (price < other.price)
        {
            return -1;
        }
        else if (price > other.price)
        {
            return 1;
        }
        return 0;
    }*/

    public String getMaterial()
    {
        return material;
    }

    public String getType()
    {
        return type;
    }

    public int getSize()
    {
        return size;
    }

    public double getPrice()
    {
        return price;
    }

    @Override
    public String toString()
    {
        return "Clothes{" +
                "material='" + material + '\'' +
                ", type='" + type + '\'' +
                ", size=" + size +
                ", price=" + price +
                '}';
    }
}