package edu.greenriver.sdev.resttemplatejokes.controller;

import edu.greenriver.sdev.resttemplatejokes.model.Joke;
import edu.greenriver.sdev.resttemplatejokes.service.AppJokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebPageController {

    private AppJokeService service;

    public WebPageController(AppJokeService service){
        this.service = service;
    }

    @GetMapping("index")
    public String getIndex(Model model){

        Joke[] jokes = service.getAllJokes();
        model.addAttribute("jokes", jokes);
        return "index";
    }
}
