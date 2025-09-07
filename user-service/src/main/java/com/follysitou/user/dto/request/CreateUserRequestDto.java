package com.follysitou.user.dto.request;

import com.follysitou.user.model.Group;
import com.follysitou.user.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
public class CreateUserRequestDto {

    @NotBlank(message = "Username is required")
    @Size(min=3, max=20, message="Username must be between 3 and 20 characters")
    private String username;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Lastname is required")
    private String lastName;

    @NotBlank(message = "Password is required")
    @Size(min=6, max=100, message="Password must be between 6 and 100 characters")
    private String password;

    @NotBlank(message = "Email is required")
    @Email(message = "Please, provide correct email")
    private String email;

    private String status;

    private Set<Role> roles;

    private Set<Group> groups;

}
