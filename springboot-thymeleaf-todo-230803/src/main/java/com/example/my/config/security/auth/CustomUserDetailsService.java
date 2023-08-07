package com.example.my.config.security.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.my.common.exception.BadRequestException;
import com.example.my.config.security.auth.CustomUserDetails.User;
import com.example.my.config.security.auth.CustomUserDetails.User.UserBuilder;
import com.example.my.model.user.entity.UserEntity;
import com.example.my.model.user.entity.UserRoleEntity;
import com.example.my.model.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Optional<UserEntity> userEntityOptional = userRepository.findByIdAndDeleteDateIsNull(username);

        if (userEntityOptional.isEmpty()) {
            throw new BadRequestException("아이디를 정확히 입력해주세요");
        }

        UserEntity userEntity = userEntityOptional.get();

        // List<String> roleList = userEntity.getUserRoleEntityList().stream()
        // .map(userRoleEntity -> userRoleEntity.getRole())
        // .toList();

        List<String> roleList = new ArrayList<>();

        for (UserRoleEntity userRoleEntity : userEntity.getUserRoleEntityList()) {
            roleList.add(userRoleEntity.getRole());
        }

        User user = new UserBuilder()
        .idx(userEntity.getIdx())
        .id(userEntity.getId())
        .password(userEntity.getPassword())
        .roleList(roleList)
        .build();

        return new CustomUserDetails(user);

    }
    
}
