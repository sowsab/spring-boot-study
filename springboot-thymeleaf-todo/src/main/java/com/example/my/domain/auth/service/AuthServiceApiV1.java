package com.example.my.domain.auth.service;

import com.example.my.common.dto.ResponseDTO;
import com.example.my.domain.auth.dto.ReqJoinDTO;
import com.example.my.domain.auth.dto.ReqLoginDTO;
import com.example.my.model.user.entity.UserEntity;
import com.example.my.model.user.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthServiceApiV1 {

    private final UserRepository userRepository;

    public ResponseEntity<?> login(ReqLoginDTO dto, HttpSession session) {
        // TODO : 리파지토리에서 아이디로 삭제되지 않은 유저 찾기
        // TODO : 없으면 (존재하지 않는 사용자입니다.) 메시지 리턴
        // TODO : 비밀번호가 일치하지 않으면 (비밀번호가 일치하지 않습니다.) 메시지 리턴
        // TODO : 세션에 로그인 유저 정보 저장
        // TODO : 응답 데이터로 리턴하기 (로그인에 성공하였습니다.)
        return null;
    }

    @Transactional
    public ResponseEntity<?> join(ReqJoinDTO dto) {
        if (dto.getUser().getId() == null ||
                dto.getUser().getId().equals("") ||
                dto.getUser().getPassword() == null ||
                dto.getUser().getPassword().equals("")) {
            return new ResponseEntity<>(
                    ResponseDTO.builder()
                            .code(1)
                            .message("아이디나 비밀번호를 입력해주세요")
                            .build(),
                    HttpStatus.BAD_REQUEST);
        }

        Optional<UserEntity> userEntityOptional = userRepository.findById(dto.getUser().getId());

        if (userEntityOptional.isPresent()) {
            return new ResponseEntity<>(
                    ResponseDTO.builder()
                            .code(1)
                            .message("이미 존재하는 아이디 입니다")
                            .build(),
                    HttpStatus.BAD_REQUEST);
        }

        UserEntity userEntity = UserEntity.builder()
                .id(dto.getUser().getId())
                .password(dto.getUser().getPassword())
                .createDate(LocalDateTime.now())
                .build();

        userRepository.save(userEntity);

        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .code(1)
                        .message("회원가입에 성공했습니다")
                        .build(),
                HttpStatus.OK);
    }

}
