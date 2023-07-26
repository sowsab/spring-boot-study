package com.example.my.domain.auth.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    // @GetMapping("/auth/login")
    // public ModelAndView login() {
    // ModelAndView modelAndView = new ModelAndView();
    // modelAndView.setViewName("auth/login");
    // return modelAndView;
    // }

    @GetMapping("/auth/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/auth/join")
    public String join() {
        return "/auth/join";
    }

    @GetMapping("/auth/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/auth/login";
    }
}
