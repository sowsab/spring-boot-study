package com.example.site1.domain.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.site1.domain.post.dto.ResPostDTO;
import com.example.site1.domain.post.service.PostService;

@Controller
public class SecondController {
    
    @Autowired
    private PostService postService;

    @GetMapping("/post")
    public ModelAndView postPage(){
        ModelAndView modelAndView = new ModelAndView();
        List<ResPostDTO> resPostDTOList = postService.getPostData();
        modelAndView.addObject("resPostDTOList", resPostDTOList);
        modelAndView.setViewName("post/post");
        return modelAndView;
    }
    
}
