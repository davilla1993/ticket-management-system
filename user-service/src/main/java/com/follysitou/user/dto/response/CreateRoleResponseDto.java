package com.follysitou.user.dto.response;

import com.follysitou.common.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRoleResponseDto extends BaseDto {

    private Long id;

    private String name;

    private String description;

    private String status;
}
