package edu.greenriver.sdev.deployinggcp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Cesar Escalona
 * @version 1.0
 *
 * This Class will display the "Home" page front end for my API after I deploy it on GCP
 */
@Controller
public class IndexController {

    /**
     * @return returns the home page located inside the templates
     */
    @GetMapping("")
    public String home() {
        return "home";
    }
}
