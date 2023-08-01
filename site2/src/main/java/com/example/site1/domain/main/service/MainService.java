package com.example.site1.domain.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.site1.domain.main.dto.MainUserDTO;
import com.example.site1.domain.main.dto.ResMainDTO;
import com.example.site1.model.user.entity.UserEntity;
import com.example.site1.model.user.repository.UserRepository;

@Service
public class MainService {
    
    @Autowired
    private UserRepository userRepository;

    public ResMainDTO getMainData() {
        // 원두 가져오기
        List<UserEntity> userEntityList = userRepository.findAll();

        // 아메리카노 컵 준비하기
        List<MainUserDTO> mainUserDTOList = new ArrayList<>();

        for (UserEntity userEntity : userEntityList) {
            // 원두 아메리카노로 만들기
            MainUserDTO mainUserDTO = new MainUserDTO(userEntity.getIdx(), userEntity.getId());

            // 아메리카노를 컵에 담기
            mainUserDTOList.add(mainUserDTO);
        }

        // 아메리카노 포장해서 담아서 주기
        return new ResMainDTO(mainUserDTOList);

    }

}
