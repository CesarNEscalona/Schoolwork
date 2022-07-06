package edu.greenriver.sdev.springmvclab.controller;

import edu.greenriver.sdev.springmvclab.service.ChallengeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ChallengeController {
    private ChallengeService service;

    public ChallengeController(ChallengeService service){
        this.service = service;
    }
    @GetMapping("challenge")
    public String genChallenge(Model modelVars) {
        List<Integer> all = service.nums();
        modelVars.addAttribute("nums", all);
        return "challenge";
    }
}
