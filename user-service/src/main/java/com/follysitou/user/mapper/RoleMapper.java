package com.follysitou.user.mapper;

import com.follysitou.user.dto.request.CreateRoleRequestDto;
import com.follysitou.user.dto.response.CreateRoleResponseDto;
import com.follysitou.user.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring",unmappedTargetPolicy= ReportingPolicy.IGNORE)
public interface RoleMapper {

    Role toRole(CreateRoleRequestDto createRoleRequestDto);

    CreateRoleResponseDto toCreateRoleResponseDto(Role role);
}
