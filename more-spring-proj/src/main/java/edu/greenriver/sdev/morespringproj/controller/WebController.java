package edu.greenriver.sdev.morespringproj.controller;

import edu.greenriver.sdev.morespringproj.model.Surfboard;
import edu.greenriver.sdev.morespringproj.service.SurfboardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WebController {

    private SurfboardService service;

    //inject the service from the Spring context
    public WebController(SurfboardService service)
    {
        this.service = service;
    }

    //access at http://localhost:8080/products/all
    @GetMapping("products/all")
    public String getAllProducts(Model model)
    {
        List<Surfboard> allBoards = service.getAll();
        model.addAttribute("boards", allBoards);
        model.addAttribute("bestBoard", allBoards.get(0));

        return "all"; //this will load resources/templates/all.html
    }

    //access at http://localhost:8080/products/on_sale
    @GetMapping("products/on_sale")
    public String getOnSale(Model model)
    {
        List<Surfboard> onSaleBoards = service.getOnSale();
        model.addAttribute("boards", onSaleBoards);

        return "on_sale"; //this will load resources/templates/on_sale.html
    }
}
