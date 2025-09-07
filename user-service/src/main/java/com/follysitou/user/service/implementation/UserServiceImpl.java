package com.follysitou.user.service.implementation;

import com.follysitou.user.constant.Constant;
import com.follysitou.user.dto.request.CreateUserRequestDto;
import com.follysitou.user.dto.response.AuthResponse;
import com.follysitou.user.dto.response.CreateRoleResponseDto;
import com.follysitou.user.dto.response.CreateUserResponseDto;
import com.follysitou.user.exception.UserValidationException;
import com.follysitou.user.mapper.UserMapper;
import com.follysitou.user.model.Role;
import com.follysitou.user.model.User;
import com.follysitou.user.repository.RoleRepository;
import com.follysitou.user.repository.UserRepository;
import com.follysitou.user.service.RoleService;
import com.follysitou.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final RoleService roleService;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Override
    public AuthResponse create(CreateUserRequestDto createUserRequestDto) {

        if(!StringUtils.hasLength(createUserRequestDto.getUsername())) {
            throw new UserValidationException("username","Username cannot be empty");
        }

        if(!StringUtils.hasLength(createUserRequestDto.getPassword())) {
            throw new UserValidationException("password","Password cannot be empty");
        }

        if(userRepository.findByUsername(createUserRequestDto.getUsername()).isPresent()) {
            throw new UserValidationException("username", "Username already exists");
        }


        User user = userMapper.toUser(createUserRequestDto);
        user.setStatus(Constant.ACTIVE);
        if(createUserRequestDto.getRoles() == null || createUserRequestDto.getRoles().isEmpty()) {
             roleRepository.findByName(Constant.USER).ifPresent(role -> {
                 user.setRoles(Set.of(role));
             });
        } else {

            List<Role> roles = roleRepository.findAllByNameIn(createUserRequestDto.getRoles());
        }


        userRepository.save(user);

        return new AuthResponse();
    }

    @Override
    public CreateUserResponseDto update(Long id, CreateUserRequestDto createUserRequestDto) {
        return null;
    }
}
