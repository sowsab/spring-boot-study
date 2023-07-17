package com.example.coffee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoffeeController {
    
    @GetMapping("/coffee")
    public ModelAndView coffee() {
        ModelAndView coffee = new ModelAndView();
        coffee.addObject("coffee", "아메리카노");
        coffee.setViewName("coffee");
        return coffee;
    }
}
