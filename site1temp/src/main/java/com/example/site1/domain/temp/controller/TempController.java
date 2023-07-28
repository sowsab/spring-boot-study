package com.example.site1.domain.temp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.site1.domain.temp.dto.ReqTempDTO;

@Controller
public class TempController {
    
    // 도메인 매핑
    @GetMapping("/temp")
    public String temp(ReqTempDTO reqTempDTO) {

        System.out.println(reqTempDTO.getName());
        System.out.println(reqTempDTO.getAge());

        // 파일명 접근
        return "temp";
    }

    @PostMapping("/temp")
    public String temp1(ReqTempDTO reqTempDTO) {

        System.out.println(reqTempDTO.getName());
        System.out.println(reqTempDTO.getAge());

        return "temp";
    }

    @PostMapping("/file")
    // 여러 파일을 받을때는 List형식으로
    public String file(List<MultipartFile> files) {

        for (MultipartFile multipartFile : files) {
            System.out.println(multipartFile.getOriginalFilename());
            System.out.println(multipartFile.getSize());
        }

        return "redirect:temp";
    }
}
