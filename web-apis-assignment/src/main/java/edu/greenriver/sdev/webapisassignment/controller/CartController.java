package edu.greenriver.sdev.webapisassignment.controller;

import edu.greenriver.sdev.webapisassignment.model.*;
import edu.greenriver.sdev.webapisassignment.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

/**
 * This program will feature a Cart controller that can be used to read, create, and delete Products
 *
 * @author Cesar Escalona
 * @version 1.0
 */
@Controller
@RequestMapping("api/v1/carts")
public class CartController
{
    private CartService cartService;
    private UserService userService;
    private ProductService productService;

    /**
     * This Constructor features services that can be used to reference methods in another class.
     *
     * @param cartService Takes in a service that will be used to access methods from another class
     * @param userService Takes in a service that will be used to access methods from another class
     * @param productService Takes in a service that will be used to access methods from another class
     */
    public CartController(CartService cartService, UserService userService, ProductService productService){
        this.cartService = cartService;
        this.userService = userService;
        this.productService = productService;
    }

    /**
     * This method will get the cart based on a valid UUID
     *
     * @param cartId takes in a UUID to retrieve a Cart
     * @return returns the cart if found, not found otherwise
     */
    @GetMapping("{cartId}")
    public ResponseEntity<User> getCart(@PathVariable UUID cartId){
        // returns a cart associated with a given userId
        try{
            if(userService.getUserById(cartId).getId().equals(cartId)){
                return new ResponseEntity<>(userService.getUserById(cartId), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (NullPointerException error){
            // return if UUID is not found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * This method will add a Cart to a user if the ID provided is valid
     *
     * @param userId takes in a user which we can use to get their id to compare
     * @return returns the added cart if the id matches a user and the proper Http status code
     */
    @PostMapping("")
    public ResponseEntity<Cart> addCart(@RequestBody User userId){
        // if this id matches a user id, set the cartId and create empty cart
        User temp = userService.getUserById(userId.getId());
        try{
            if(temp.getId() != null){
                temp.setCart(cartService.createEmptyCart(userId.getId()));
                return new ResponseEntity<>(temp.getCart(), HttpStatus.CREATED);
            }
            // if the given UUID doesn't match a record
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch(NullPointerException err){
            // if the given UUID doesn't match a record
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * This method will add a product to a cart if the cart ID matches a user ID
     *
     * @param cartId takes in a UUID that represents a valid cart ID
     * @param product takes in a product that needs to be added to the cart
     * @return returns the cart with the product if the cart ID matches a user
     */
    @PostMapping("{cartId}")
    public ResponseEntity<Cart> addProductToCart(@PathVariable UUID cartId, @RequestBody Product product){
        // get the temp user based on cartId
        // check if the ID's match, if so, add product to cart
        User temp = userService.getUserById(cartId);
        try{
            if(temp.getCart().getId() != null){
                // add the product to the cart if the id matches
                return new ResponseEntity<>(cartService.addProductToCart(temp.getId(), product), HttpStatus.OK);
            }
            // if temp == null, means no user is found with that id
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (NullPointerException err){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * This method will delete a User's cart if the ID matches a user
     *
     * @param userId takes in the user that we need to delete the cart for
     * @return returns either no content if the cart is deleted or not found if the id doesn't match a user
     */
    @DeleteMapping("")
    public ResponseEntity<Cart> deleteCart(@RequestBody User userId){
        // get the temp user based on id
        User temp = userService.getUserById(userId.getId());
        // if there's a match, delete the cart, otherwise Not_Found
        if(temp != null){
            try{
                return new ResponseEntity<>(cartService.deleteCart(userId), HttpStatus.NO_CONTENT);
            } catch (NullPointerException invalidProduct){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * This method removes the product that matches the provided UUID and product
     *
     * @param userId takes in a valid UUID that matches a user
     * @param product takes in the product we want to delete
     * @return returns the cart after product deletion or not found if UUID does not match a record
     */
    @DeleteMapping("{userId}")
    public ResponseEntity<Cart> deleteProduct(@PathVariable UUID userId, @RequestBody Product product){
        User temp = userService.getUserById(userId);
        try{
            if(temp != null){
                try{
                    cartService.deleteProductFromCart(userId, product);
                }catch (NullPointerException err){
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(temp.getCart(), HttpStatus.OK);
            } else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        }catch (IllegalStateException invalid){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public String toString() {
        return "CartController{" +
                "cartService=" + cartService +
                ", userService=" + userService +
                ", productService=" + productService +
                '}';
    }
}
