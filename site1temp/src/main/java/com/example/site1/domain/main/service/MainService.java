package com.example.site1.domain.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.site1.domain.main.dto.ResMainDTO;
import com.example.site1.model.user.entity.UserEntity;
import com.example.site1.model.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MainService {
    
    private final UserRepository userRepository;

    public ResMainDTO getMainData() {

        // 모든 유저 가져오기
        List<UserEntity> userEntityList = userRepository.findAll();

        // dto 만들기
        List<ResMainDTO.User> userList = new ArrayList<>();

        for (UserEntity userEntity : userEntityList) {

            ResMainDTO.User user = new ResMainDTO.User(userEntity.getId());

            userList.add(user);

        }
        // 여러 정보를 담을때 DTO를 DTO로 싸버린다
        ResMainDTO resMainDTO = new ResMainDTO(userList);

        return resMainDTO;

    }

}
