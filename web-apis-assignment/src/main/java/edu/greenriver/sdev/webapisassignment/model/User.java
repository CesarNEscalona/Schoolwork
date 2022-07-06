package edu.greenriver.sdev.webapisassignment.model;

import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * This program will help create a User object with a UUId, a username, a cart, and a timestamp.
 *
 * @author Cesar Escalona
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User
{
    private UUID id;
    private String username;
    private LocalDateTime created;

    private Cart cart;

    /**
     * This method allows a User to be created with just the username provided.
     *
     * @param username The name of the User created
     */
    public User(String username)
    {
        this.username = username;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null) {
            return false;
        }
        if (!obj.getClass().equals(this.getClass())) {
            return false;
        }

        return ((User)obj).id.equals(id);
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }
}
