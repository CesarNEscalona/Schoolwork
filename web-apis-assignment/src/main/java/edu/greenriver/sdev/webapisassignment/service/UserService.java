package edu.greenriver.sdev.webapisassignment.service;

import edu.greenriver.sdev.webapisassignment.model.User;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.*;

/**
 * This program contains all the logic and methods needed for Users
 *
 * @author Cesar Escalona
 * @version 1.0
 */
@Service
public class UserService
{
    private List<User> users = new ArrayList<>();

    private UserService() {
        // add some test data
        List<User> tempUsers = List.of(
                new User( "DevMaster"),
                new User("Tester")
        );

        for (User name: tempUsers)
        {
            addUser(name);
        }
    }

    /**
     * This method gets all the users from the list
     *
     * @return returns all users on the list
     */
    public List<User> getUsers(){
        return users;
    }

    /**
     * This method uses the UUID to find a User and returns them
     *
     * @param id takes in a provided UUID that's needed to find a User
     * @return returns the User with that UUID
     */
    // get user by id
    public User getUserById(UUID id){
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst().orElse(null);
    }


    /**
     * This method finds if the UUID provided matches a User or not
     *
     * @param userId takes in a UUID to look for the User
     * @return returns the User associated with that ID
     */
    public boolean idMatchesUser(UUID userId){
        return userId.equals(getUserById(userId).getId());
    }

    /**
     * This method will create a new User based on the name passed in
     *
     * @param userName Takes in a Username for a User that will be used to create a new User
     * @return returns the user created
     */
    public User addUser(User userName){
        userName.setId(UUID.randomUUID());
        userName.setCreated(LocalDateTime.now());
        users.add(userName);
        return userName;
    }

    /**
     * This method checks if a username is valid and returns a boolean
     *
     * @param user takes in a user to verify if the name is empty or not
     * @return returns a boolean if the username is empty, blank, or null
     */
    public boolean emptyUser(User user){
        // check if null or not
        return user.getUsername().isEmpty() || user.getUsername().isBlank() || user.getUsername() == null;
    }

    /**
     * This method finds a user based on the UUID and edits them
     *
     * @param id takes in a UUID used to find a user to edit
     * @param editedName takes in a user that can be used to edit the username
     * @return returns the updated/edited user
     */
    public User editUser(UUID id, User editedName){
        User savedUser = getUserById(id);
        if(savedUser.getId().equals(id)){
            savedUser.setUsername(editedName.getUsername());
            return savedUser;
        }
        else {
            // if no username is found by that Id
            throw new IllegalArgumentException("Username with id " + id + " not found!");
        }
    }

    /**
     * This method will delete a user if the UUID provided matches a record
     *
     * @param userId takes in a UUID that is used to find a user to delete
     * @return returns the user who was deleted
     */
    public User deleteUser(UUID userId){
        User savedUser = getUserById(userId);
        if(savedUser.getId().equals(userId)){
            users.remove(savedUser);
        }
        return savedUser;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "users=" + users +
                '}';
    }
}
