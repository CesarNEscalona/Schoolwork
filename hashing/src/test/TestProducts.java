package test;

import model.Product;

public class TestProducts
{
    public static void main(String[] args)
    {
        Product myProduct1 = new Product(2, 19.99, "bowling ball", true);
        System.out.println(myProduct1.hashCode());

        Product myProduct2 = new Product(2, 19.99, "bowling ball", true);
        System.out.println(myProduct2.hashCode());
    }
}