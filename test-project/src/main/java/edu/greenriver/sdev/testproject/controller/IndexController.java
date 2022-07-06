package edu.greenriver.sdev.testproject.controller;

import edu.greenriver.sdev.testproject.model.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 *
 * @author Cesar Escalona
 * @version 1.0
 * This class will be the controller for my Spring app.
 */
@RestController
public class IndexController {
    private List<Message> messages = List.of(
            new Message("Hello World!"),
            new Message("Welcome to my Spring App"),
            new Message("Hope you had fun"),
            new Message("Wish you the best!")
    );

    /**
     * @return returns all of the messages stored in the list of messages
     */
    // this web resource is available at http://localhost:8080/hello
    @GetMapping("hello")
    public List<Message> getAllMessages() {
        return messages;
    }
}