package com.example.site1.domain.post.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.site1.domain.post.dto.ResPostDTO;
import com.example.site1.model.post.repository.PostRepository;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;   

    public List<ResPostDTO> getPostData() {

        return postRepository.findAll()
        .stream()
        .map((postEntity) -> ResPostDTO.fromEntity(postEntity))
        .toList();

    }

}
