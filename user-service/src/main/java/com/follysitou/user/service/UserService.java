package com.follysitou.user.service;

import com.follysitou.user.dto.request.CreateUserRequestDto;
import com.follysitou.user.dto.response.AuthResponse;
import com.follysitou.user.dto.response.CreateUserResponseDto;

public interface UserService {

    AuthResponse create(CreateUserRequestDto createUserRequestDto);
    CreateUserResponseDto update(Long id, CreateUserRequestDto createUserRequestDto);
}
