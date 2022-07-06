package edu.greenriver.sdev.springmvclab.controller;

import edu.greenriver.sdev.springmvclab.service.ChallengeService;
import edu.greenriver.sdev.springmvclab.service.NumberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NumberController {
    private NumberService service;

    public NumberController(NumberService service){
        this.service = service;
    }

    @GetMapping("randnum")
    public String genNumber(Model modelVars) {
        modelVars.addAttribute("num", service.between(1, 20));
        return "randnum";
    }

    @GetMapping("powerball")
    public String genNumbers(Model modelVars) {
        modelVars.addAttribute("num1", service.between(1, 69));
        modelVars.addAttribute("num2", service.between(1, 69));
        modelVars.addAttribute("num3", service.between(1, 69));
        modelVars.addAttribute("num4", service.between(1, 69));
        modelVars.addAttribute("num5", service.between(1, 69));
        modelVars.addAttribute("num6", service.between(1, 29));
        return "powerball";
    }
}
