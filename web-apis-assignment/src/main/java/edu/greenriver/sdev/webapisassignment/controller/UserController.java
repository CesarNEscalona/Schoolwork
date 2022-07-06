package edu.greenriver.sdev.webapisassignment.controller;

import edu.greenriver.sdev.webapisassignment.model.User;
import edu.greenriver.sdev.webapisassignment.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

/**
 * This program features methods that can update a user, create a user, delete a user, and get users.
 *
 * @author Cesar Escalona
 * @version 1.0
 */
@Controller
@RequestMapping("api/v1/users")
public class UserController
{
    private UserService service;

    /**
     * This default constructor features a service that can be used to reference methods in another class.
     *
     * @param service Takes in a service that will be used to access methods in another class
     */
    public UserController(UserService service){
        this.service = service;
    }

    /**
     * This method returns all users
     *
     * @return returns all user resources and http status codes associated with requests
     */
    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(){

        return new ResponseEntity<>(service.getUsers(), HttpStatus.OK);
    }

    /**
     * This method will return a single User based on the ID passed in.
     *
     * @param userId The Users UUID that is specific to a user
     * @return returns a User and Http status code affiliated with the request
     */
    @GetMapping("{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable UUID userId){
        try{
            if(service.idMatchesUser(userId)){
                return new ResponseEntity<>(service.getUserById(userId), HttpStatus.OK);
            }
            else if(!service.idMatchesUser(userId)){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else{
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (NullPointerException err){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * This method will be used to add a User
     *
     * @param userName Takes in a User that will be added
     * @return returns the User added into the Users list with affiliated Http status codes
     */
    @PostMapping("")
    // return response entity like the one above
    public ResponseEntity<User> addUser(@RequestBody User userName){
        if(service.emptyUser(userName)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>(service.addUser(userName), HttpStatus.CREATED);
        }
    }

    /**
     * This method will be used to update a User
     *
     * @param userId Takes in a User that we will need to update
     * @return returns the User that gets updated with affiliated Http status codes
     */
    @PutMapping("")
    public ResponseEntity<User> updateUser(@RequestBody User userId){
        // if id does not match a user, return not found
        if(!userId.equals(service.getUserById(userId.getId()))){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // if username passed in is empty return a bad request
        else if(userId.getUsername().isEmpty() || userId.getUsername().isBlank()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        // otherwise, add it
        else {
            return new ResponseEntity<>(service.editUser(userId.getId(), userId), HttpStatus.OK);
        }
    }

    /**
     * This method will be used to delete a User
     *
     * @param id takes in a UUID that is connected to a User
     * @param user Takes in the User we will be deleting
     * @return returns the Http status codes based on the request
     */
    @DeleteMapping("{id}")
    public ResponseEntity<User> deleteUser(@PathVariable UUID id, User user){
        if(!user.equals(service.getUserById(id))){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service.deleteUser(id), HttpStatus.NO_CONTENT);
    }

    @Override
    public String toString() {
        return "UserController{" +
                "service=" + service +
                '}';
    }
}
