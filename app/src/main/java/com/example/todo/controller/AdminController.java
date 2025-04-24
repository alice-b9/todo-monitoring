package com.example.todo.controller;

import com.example.todo.domain.AppUser;
import com.example.todo.repository.AppUserRepository;
import com.example.todo.repository.TodoRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name="Admin", description = "관리자 기능")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final TodoRepository todoRepository;
    private final AppUserRepository appUserRepository;

    @GetMapping("/stats")
    public Map<String, Object> stats() {
        Map<String, Object> map = new HashMap<>();
        map.put("total", todoRepository.count());
        map.put("completed", todoRepository.countByCompleted(true));
        map.put("incomplete", todoRepository.countByCompleted(false));
        return map;
    }

    @GetMapping("/users")
    public List<AppUser> users() {
        return appUserRepository.findAll();
    }
}
