package com.example.SpringWeb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home( Model model) {
        model.addAttribute("title", "Main page");
        return "home";
    }
    @GetMapping("/home")
    public String homee( Model model) {
        model.addAttribute("title", "Main page");
        return "home";
    }
    @GetMapping("explore")
    public String explore( Model model) {
        model.addAttribute("title", "Explore");
        return "explore";
    }
    @GetMapping("booking")
    public String booking( Model model) {
        model.addAttribute("title", "Explore");
        return "booking";
    }
    @GetMapping("contact")
    public String contact( Model model) {
        model.addAttribute("title", "Explore");
        return "contact";
    }
    @GetMapping("place")
    public String place( Model model) {
        model.addAttribute("title", "Explore");
        return "place";
    }



}