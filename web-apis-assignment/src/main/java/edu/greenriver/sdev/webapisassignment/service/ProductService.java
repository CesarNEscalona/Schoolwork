package edu.greenriver.sdev.webapisassignment.service;

import edu.greenriver.sdev.webapisassignment.model.Product;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * This program contains all logic and methods needed for products
 *
 * @author Cesar Escalona
 * @version 1.0
 */
@Service
public class ProductService
{
    public static final double PRICE1 = 2000.00;
    public static final double PRICE2 = 2300.00;
    private List<Product> products = new ArrayList<>();

    private ProductService(){
        // Add test data
        List<Product> testProducts = List.of(
                new Product("2070", PRICE1, "GigaByte", 1),
                new Product("rtx", PRICE2, "GeForce", 2)
        );
        for (Product prods: testProducts) {
            // add product with created add method
            addProduct(prods);
        }
    }

    /**
     * This method returns all products
     *
     * @return returns the products on the list
     */
    // get all products
    public List<Product> getProducts(){
        return products;
    }

    /**
     * This method returns a product if the name passed in matches a record
     *
     * @param prodName takes a string as the products name
     * @return returns the product if the name matches
     */
    public Product getProdByName(String prodName){
        return products.stream()
                .filter(product -> product.getName().equals(prodName))
                .findFirst().orElse(null);
    }

    /**
     * This method returns a boolean if the product name matches a product
     *
     * @param prodName takes in a string and checks if it matches the name of a product
     * @return returns a boolean if the name matches a product
     */
    public boolean nameMatchesProd(String prodName){
        // get product by name
        return prodName.equals(getProdByName(prodName).getName());
    }

    /**
     * This method creates a new product
     *
     * @param product takes in a product obj and creates a product
     * @return returns the product created
     */
    public Product addProduct(Product product){
        String name = product.getName();
        double price = product.getPrice();
        String desc = product.getDescription();
        int quantity = product.getQuantity();
        products.add(new Product(name, price, desc, quantity));
        return getProdByName(name);
    }

    /**
     * This method verifies that a product is valid and returns a boolean based on that
     *
     * @param product takes in a product to evaluate
     * @return returns if the product is valid or not based on the conditions
     */
    public boolean validProduct(Product product){
        // if any fields are empty, return false
        if(product.getName().isEmpty()){
            return false;
        } else if(product.getName().isBlank()){
            return false;
        } else if(product.getDescription().isEmpty()){
            return false;
        } else if(product.getPrice() == 0){
            return false;
        } else {
            return product.getQuantity() != 0;
        }
    }

    /**
     * This method updates a product and its fields
     *
     * @param product takes in a product that is used to verify if a product exists
     * @return returns the product that has been updated
     */
    public Product updateProd(Product product){
        Product match = getProdByName(product.getName());
        if(match.getName().equals(product.getName())){
            match.setQuantity(product.getQuantity());
            match.setPrice(product.getPrice());
            match.setDescription(product.getDescription());
            match.setName(product.getName());
        } else{
            throw new IllegalArgumentException("The product wasn't updated due to an error");
        }
        return match;
    }

    @Override
    public String toString() {
        return "ProductService{" +
                "products=" + products +
                '}';
    }
}
