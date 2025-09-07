package com.follysitou.user.dto.request;

import lombok.Data;

@Data
public class CreateRoleRequestDto {

    private String name;

    private String description;

    private String status;
}
