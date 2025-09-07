package com.follysitou.user.service.implementation;

import com.follysitou.user.constant.Constant;
import com.follysitou.user.dto.request.CreateRoleRequestDto;
import com.follysitou.user.dto.response.CreateRoleResponseDto;
import com.follysitou.user.exception.RoleValidationException;
import com.follysitou.user.mapper.RoleMapper;
import com.follysitou.user.model.Role;
import com.follysitou.user.repository.RoleRepository;
import com.follysitou.user.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;


    @Override
    public CreateRoleResponseDto create(CreateRoleRequestDto createRoleRequestDto) {
        if(!StringUtils.hasText(createRoleRequestDto.getName())) {
            throw new RoleValidationException("Role name","Role name cannot be empty");
        }

        if(roleRepository.findByName(createRoleRequestDto.getName()).isPresent()) {
            throw new RoleValidationException("Role name","Role name already exists");
        }

        Role role = roleMapper.toRole(createRoleRequestDto);
        role.setStatus(Constant.ACTIVE);

        roleRepository.save(role);

        return roleMapper.toCreateRoleResponseDto(role);
    }

    @Override
    public CreateRoleResponseDto update(Long id, CreateRoleRequestDto createRoleRequestDto) {
        return null;
    }

    @Override
    public CreateRoleResponseDto findById(Long id) {
        return null;
    }

    @Override
    public CreateRoleResponseDto findByName(String name) {
        return roleRepository.findByName(name)
                .map(roleMapper::toCreateRoleResponseDto)
                .orElse(null);
    }

    @Override
    public List<CreateRoleResponseDto> findAll() {
        return List.of();
    }

    @Override
    public List<CreateRoleResponseDto> findAllRoleActive(String status) {
        return List.of();
    }
}
