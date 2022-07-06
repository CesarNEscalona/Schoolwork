package edu.greenriver.sdev.webapisassignment.service;

import edu.greenriver.sdev.webapisassignment.model.*;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * This program contains all logic and methods needed for carts
 *
 * @author Cesar Escalona
 * @version 1.0
 */
@Service
public class CartService
{
    private List<Cart> carts = new ArrayList<>();
    private List<Product> listItems = new ArrayList<>();


    private CartService(){
        // No test data...null
    }

    /**
     * This method returns a cart that matches the provided ID
     *
     * @param userId takes in a UUID to verify a user's cart
     * @return returns the cart id if available, otherwise null
     */
    public Cart getCartById(UUID userId){
        return carts.stream()
                .filter(cart -> cart.getId().equals(userId))
                .findFirst().orElse(null);  // returns null if cart is null
    }

    /**
     * This method will create an empty cart is the UUID provided matches a user
     *
     * @param userId takes in a UUID that is used to find a user
     * @return returns the cart added for that user
     */
    public Cart createEmptyCart(UUID userId){
        // creates a new cart (empty) for the user
        Cart cart = new Cart(userId, listItems);
        cart.setId(userId);
        carts.add(cart);
        return cart;
    }


    /**
     * This method will add a product to a cart based on the parameters passed in
     *
     * @param userId takes in a UUID for a valid user
     * @param product takes in the product we want to add
     * @return returns the cart after the product is added to it
     */
    public Cart addProductToCart(UUID userId, Product product ){
        Cart match = getCartById(userId);
        // Add prod to list
        match.addProduct(product);
        return match;
    }

    /**
     * This method will delete a cart from a user
     *
     * @param userId takes in a user we can use to find an ID
     * @return returns the cart matched after deletion
     */
    public Cart deleteCart(User userId){
        if(getCartById(userId.getId()) != null){
            Cart match = getCartById(userId.getId());
            carts.remove(match);
            match.setListItems(null);
            match.setId(null);
            return match;
        }
        return null;
    }

    /**
     * This method will delete a product from the cart
     *
     * @param userId takes in a UUID for a valid user we want to update
     * @param product takes in a product we want to delete
     */
    public void deleteProductFromCart(UUID userId, Product product){
        Cart match = getCartById(userId);
        match.removeProduct(product);
    }


    @Override
    public String toString() {
        return "CartService{" +
                "carts=" + carts +
                ", listItems=" + listItems +
                '}';
    }
}
