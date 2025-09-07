package com.follysitou.user.controller;

import com.follysitou.user.dto.request.CreateRoleRequestDto;
import com.follysitou.user.dto.response.CreateRoleResponseDto;
import com.follysitou.user.service.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;


    @PostMapping
    public ResponseEntity<CreateRoleResponseDto> createRole(@Valid @RequestBody CreateRoleRequestDto createRoleRequestDto) {
        return ResponseEntity.ok(roleService.create(createRoleRequestDto));
    }
}
