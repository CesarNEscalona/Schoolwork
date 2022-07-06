package test;

import model.Product;

import java.util.HashSet;

public class DangerWithHashtables
{
    public static void main(String[] args)
    {
        HashSet<Product> productsSet = new HashSet<>();

        //create a product and add it to the table
        Product myProduct1 = new Product(2, 19.99, "bowling ball", true);
        Product myProduct2 = new Product(3, 9.99, "ball point pen", false);
        productsSet.add(myProduct1);
        productsSet.add(myProduct2);

        System.out.println(productsSet);

        //let's change one of our products
        myProduct1.setName("super pink bowling ball");
        System.out.println(productsSet);

        System.out.println(productsSet.contains(myProduct1));
        System.out.println(productsSet.contains(myProduct2));
    }
}