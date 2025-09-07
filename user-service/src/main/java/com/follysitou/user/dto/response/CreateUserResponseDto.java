package com.follysitou.user.dto.response;

import com.follysitou.common.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserResponseDto extends BaseDto {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String userImage;
    private String password;
    private boolean enabled;
    private String email;
    private String userType;
    private String gender;
    private String status;
}
