package com.example.site1.domain.second.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.site1.domain.second.dto.ResSecondDTO;
import com.example.site1.model.post.entity.PostEntity;
import com.example.site1.model.post.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SecondService {

    private final PostRepository postRepository;

    public ResSecondDTO getSecondData() {
        // 모든 post 데이터 가져오기 List<PostEntity>
        List<PostEntity> postEntityList = postRepository.findAll();

        List<ResSecondDTO.Post> postList = new ArrayList<>();

        // List<PostEntity> 반목문 돌려서 PostDTO 만들기
        for (PostEntity postEntity : postEntityList) {

            ResSecondDTO.Post.User user = new ResSecondDTO.Post.User(postEntity.getUserEntity().getIdx());

            ResSecondDTO.Post post = new ResSecondDTO.Post(postEntity.getTitle(), postEntity.getContent(), user);

            // List<PostDTO> 에 담기
            postList.add(post);
        }

        // ResSecondDTO에 List<PostDTO> 담기
        ResSecondDTO resSecondDTO = new ResSecondDTO(postList);

        return resSecondDTO;

    }

}
