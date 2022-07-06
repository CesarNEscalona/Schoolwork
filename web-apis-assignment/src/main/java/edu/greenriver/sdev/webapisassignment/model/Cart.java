package edu.greenriver.sdev.webapisassignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

/**
 * This program creates a Cart object that consists of an Id and a list of items (products)
 *
 * @author Cesar Escalona
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart
{
    private UUID id;
    private List<Product> listItems = new ArrayList<>();

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null) {
            return false;
        }
        if (!obj.getClass().equals(this.getClass())) {
            return false;
        }

        return ((Cart)obj).id.equals(id);
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }

    /**
     * This method returns a product based on the product's name, returns null if the product isn't found.
     *
     * @param product Takes in a product object and returns the product by name if the name matches
     * @return returns the project if there's a match, otherwise returns null
     */
    public Product getProductByName(Product product)
    {
        return listItems
            .stream()
            .filter(prod -> prod.getName().equals(product.getName()))
            .findFirst()
            .orElse(null);
    }

    /**
     * This method adds a product to a cart, increases quantity.
     *
     * @param product The product passed in to add
     */
    public void addProduct(Product product)
    {
        Product match = getProductByName(product);
        if (match != null)
        {
            int quantity = match.getQuantity();
            quantity++;
            match.setQuantity(quantity);
        }
        else
        {
            product.setQuantity(1);
            listItems.add(product);
        }
    }

    /**
     * This method removes a product from the cart, decreases quantity.
     *
     * @param product The product passed in to remove
     */
    public void removeProduct(Product product)
    {
        Product match = getProductByName(product);
        if (match != null)
        {
            int quantity = match.getQuantity();
            quantity--;

            if (quantity == 0)
            {
                listItems.remove(product);
            }
            else
            {
                match.setQuantity(quantity);
            }
        }
        else
        {
            throw new IllegalStateException("Cart does not contain product");
        }
    }
}
