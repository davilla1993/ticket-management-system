package com.follysitou.user.service;

import com.follysitou.user.dto.request.CreateRoleRequestDto;
import com.follysitou.user.dto.response.CreateRoleResponseDto;

import java.util.List;

public interface RoleService {

    CreateRoleResponseDto create(CreateRoleRequestDto createRoleRequestDto);

    CreateRoleResponseDto update(Long id, CreateRoleRequestDto createRoleRequestDto);

    CreateRoleResponseDto findById(Long id);

    CreateRoleResponseDto findByName(String name);

    List<CreateRoleResponseDto> findAll();

    List<CreateRoleResponseDto> findAllRoleActive(String status);

}
