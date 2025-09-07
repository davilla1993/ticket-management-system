package com.follysitou.user.mapper;

import com.follysitou.user.dto.request.CreateUserRequestDto;
import com.follysitou.user.dto.response.AuthResponse;
import com.follysitou.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring",unmappedTargetPolicy= ReportingPolicy.IGNORE)
public interface UserMapper {

    User toUser(CreateUserRequestDto createUserRequestDto);

    AuthResponse toAuthResponse(User user);
}
