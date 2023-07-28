package com.example.my.domain.todo.controller;

import com.example.my.common.dto.LoginUserDTO;
import com.example.my.domain.todo.dto.ReqTodoTableInsertDTO;
import com.example.my.domain.todo.dto.ReqTodoTableUpdateDoneYnDTO;
import com.example.my.domain.todo.service.TodoServiceApiV1;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todo")
public class TodoControllerApiV1 {

    private final TodoServiceApiV1 todoServiceApiV1;

    @GetMapping
    public ResponseEntity<?> getTodoTableData(HttpSession session) {
        // 서비스에서 할 일 목록 가져오기
        LoginUserDTO loginUserDTO = (LoginUserDTO)session.getAttribute("dto");
        return todoServiceApiV1.getTodoTableData(loginUserDTO);
    }

    @PostMapping
    public ResponseEntity<?> insertTodoTableData(
            @RequestBody ReqTodoTableInsertDTO dto,
            HttpSession session
    ) {
        // 서비스에서 할 일 추가하기
        LoginUserDTO loginUserDTO = (LoginUserDTO)session.getAttribute("dto");
        return todoServiceApiV1.insertTodoTableData(dto, loginUserDTO);
    }

    @PutMapping("/{todoIdx}")
    public ResponseEntity<?> updateTodoTableData(
            @PathVariable Long todoIdx,
            @RequestBody ReqTodoTableUpdateDoneYnDTO dto,
            HttpSession session
    ) {
        // 서비스에서 할 일 완료 수정하기
        LoginUserDTO loginUserDTO = (LoginUserDTO)session.getAttribute("dto");
        return todoServiceApiV1.updateTodoTableData(todoIdx, dto, loginUserDTO);
    }

    @DeleteMapping("/{todoIdx}")
    public ResponseEntity<?> deleteTodoTableData(
            @PathVariable Long todoIdx,
            HttpSession session
    ) {
        // 서비스에서 할 일 삭제하기
        LoginUserDTO loginUserDTO = (LoginUserDTO)session.getAttribute("dto");
        return todoServiceApiV1.deleteTodoTableData(todoIdx, loginUserDTO);
    }


}
