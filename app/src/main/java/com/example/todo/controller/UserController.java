package com.example.todo.controller;

import com.example.todo.domain.AppUser;
import com.example.todo.service.AppUserDetailsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="User", description = "사용자 관리")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final AppUserDetailsService appUserDetailsService;

    @PostMapping("/register")
    public void register(@RequestBody AppUser appUser) {
        appUserDetailsService.register(appUser.getUsername(), appUser.getPassword());
    }
}
