package com.follysitou.user.controller;

import com.follysitou.user.dto.request.CreateUserRequestDto;
import com.follysitou.user.dto.response.AuthResponse;
import com.follysitou.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    private ResponseEntity<AuthResponse> createUser(@Valid @RequestBody CreateUserRequestDto createUserRequestDto) {
        return ResponseEntity.ok(userService.create(createUserRequestDto));
    }
}
