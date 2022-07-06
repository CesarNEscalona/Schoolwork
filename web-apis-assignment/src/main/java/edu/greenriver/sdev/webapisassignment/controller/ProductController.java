package edu.greenriver.sdev.webapisassignment.controller;

import edu.greenriver.sdev.webapisassignment.model.Product;
import edu.greenriver.sdev.webapisassignment.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * This program will feature a Product controller that can be used to read, create, and update Products
 *
 * @author Cesar Escalona
 * @version 1.0
 */
@Controller
@RequestMapping("api/v1/products")
public class ProductController
{
    private ProductService service;

    /**
     * This default constructor features a service that can be used to reference methods in another class.
     *
     * @param service Takes in a service that will be used to access methods in another class
     */
    public ProductController(ProductService service){
        this.service = service;
    }

    /**
     * This method will return the products that have been created
     *
     * @return returns all products that are on the list
     */
    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(service.getProducts(), HttpStatus.OK);
    }

    /**
     * This method returns a product if the name passed in matches
     *
     * @param name takes in a String that can be used to access a product by its name
     * @return returns the product if the name matches
     */
    @GetMapping("{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable String name){
        // if name doesn't match, return not found
        // try ResponseBody, and service.getProdByName in the response entity
        try{
            if(!service.nameMatchesProd(name)){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(service.getProdByName(name), HttpStatus.OK);
        } catch (NullPointerException error){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    /**
     * This method adds a product if the prod being passed in is valid
     *
     * @param prod takes in a product that will be added into the list of products
     * @return returns the product added or returns various Http request status codes
     */
    @PostMapping("")
    public ResponseEntity<Product> addProduct(@RequestBody Product prod){
        // if product are fields are empty(not in the body) return 400
        if(!service.validProduct(prod)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(service.addProduct(prod), HttpStatus.CREATED);
    }

    /**
     * This method will update a product if the product passed in is valid and if the name matches
     *
     * @param productEdit takes in the product we need to update
     * @return returns bad request, not found, or the updated product based on the pre-conditions
     */
    @PutMapping("")
    public ResponseEntity<Product> updateProduct(@RequestBody Product productEdit){
        // return 400 if prod fields are empty
        if(!service.validProduct(productEdit)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        // return 404 if prod name does not match
        else if(!productEdit.equals(service.getProdByName(productEdit.getName()))){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // return 200 when updated
        else{
            return new ResponseEntity<>(service.updateProd(productEdit), HttpStatus.OK);
        }
    }

    @Override
    public String toString() {
        return "ProductController{" +
                "service=" + service +
                '}';
    }
}
