package model;

public class Product
{
    private int id;
    private double price;
    private String name;
    private boolean onSale;

    public Product(int id, double price, String name, boolean onSale)
    {
        this.id = id;
        this.price = price;
        this.name = name;
        this.onSale = onSale;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.price, price) != 0) return false;
        if (onSale != product.onSale) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result;
        long temp;
        temp = Double.doubleToLongBits(price);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (onSale ? 1 : 0);
        return result;
    }

    public int getId()
    {
        return id;
    }

    public double getPrice()
    {
        return price;
    }

    public String getName()
    {
        return name;
    }

    public boolean isOnSale()
    {
        return onSale;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setOnSale(boolean onSale)
    {
        this.onSale = onSale;
    }

    @Override
    public String toString()
    {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", onSale=" + onSale +
                '}';
    }
}