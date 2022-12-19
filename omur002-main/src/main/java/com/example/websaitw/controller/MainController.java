package com.example.websaitw.controller;
import com.example.websaitw.models.Adress;
import com.example.websaitw.models.repos.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MainController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping()
    public String home(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "home";
    }

    @GetMapping("/explore")
    public String about(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "explore";
    }

    @GetMapping("/login")
    public String login (Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "login";
    }
    @GetMapping("/contact")
   public String showContactForm() {
      return "contact";
   }
    Adress lastAdress;
    @PostMapping("/contact")
    public String buyit(@ModelAttribute Adress adress){
        lastAdress = adress;
        senderService.sendEmail(adress.getEmail(), adress.getAdress(), adress.getPhone());

        return "redirect:/contact";
    }
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private EmailSenderService senderService;
}