package com.example.hr1.domain.temp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/temp")
public class TempControllerApiV1 {
    
    @GetMapping("/200")
    // <?>는 어떤것이 들어가도 상관 없다
    public ResponseEntity<?> get200() {

        return new ResponseEntity<>("성공", HttpStatus.OK);

    }

    @GetMapping("/400")
    public ResponseEntity<?> get400() {

        return new ResponseEntity<>("잘못된 요청", HttpStatus.BAD_REQUEST);

    }

    // 401
    @GetMapping("/401")
    public ResponseEntity<?> get401() {

        return new ResponseEntity<>("로그인 필요", HttpStatus.UNAUTHORIZED);

    }
    // 403
    @GetMapping("/403")
    public ResponseEntity<?> get403() {

        return new ResponseEntity<>("요청 거부", HttpStatus.FORBIDDEN);

    }
    // 404
    @GetMapping("/404")
    public ResponseEntity<?> get404() {

        return new ResponseEntity<>("데이터 없음", HttpStatus.NOT_FOUND);

    }
    // 405
    @GetMapping("/405")
    public ResponseEntity<?> get405() {

        return new ResponseEntity<>("대상 리소스가 이 메서드를 지원하지 않음", HttpStatus.METHOD_NOT_ALLOWED);

    }
    // 500
    @GetMapping("/500")
    public ResponseEntity<?> get500() {

        return new ResponseEntity<>("서버 내부 에러", HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
