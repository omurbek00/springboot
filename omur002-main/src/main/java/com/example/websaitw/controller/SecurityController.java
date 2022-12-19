package com.example.websaitw.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//@Controller
public class SecurityController {
    @Secured(value={"ROLE_ADMIN"})
    @RequestMapping(value= "/adminMethodSecured", method= RequestMethod.GET)
    public ModelAndView adminMethodSecured() {
        System.out.println("SecurityController adminMethodSecured() is called with ADMIN ROLE");
        return new ModelAndView("/admin");

    }
    @PreAuthorize("hasRole('ADMIN') || hasRole('USER')")
    @RequestMapping(value= "/userOrAdminCanCallSpEL", method=RequestMethod.GET)
    public ModelAndView userOrAdminCanCall() {
        System.out.println("SecurityController userOrAdminCanCall() is called with ROLE_ADMIN or ROLE_USER");
        return new ModelAndView("home");
    }
}
