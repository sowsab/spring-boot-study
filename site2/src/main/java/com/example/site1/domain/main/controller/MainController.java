package com.example.site1.domain.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.site1.domain.main.dto.ResMainDTO;
import com.example.site1.domain.main.service.MainService;

@Controller
public class MainController {
    
    @Autowired
    private MainService mainService;

    @GetMapping("/")
    public String getMainPage(Model model) {
        ResMainDTO dto = mainService.getMainData();
        model.addAttribute("dto", dto);
        return "main";

    }

    // @GetMapping("/")
    // public ModelAndView mainPage() {
    //     ModelAndView modelAndView = new ModelAndView();

    //     ResMainDTO dto = mainService.getMainData();
    //     modelAndView.addObject("dto", dto);
    //     modelAndView.setViewName("main");
        
    //     return modelAndView;

    // }

}
