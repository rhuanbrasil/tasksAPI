package com.API.tasks.business.dtos;

import com.API.tasks.infrastructure.entitys.UserRole;
import jakarta.validation.constraints.NotBlank;

public record UserRegisterDTO(@NotBlank String login, @NotBlank String password, UserRole role) {
}
