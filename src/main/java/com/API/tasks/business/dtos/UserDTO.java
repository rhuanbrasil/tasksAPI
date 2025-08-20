package com.API.tasks.business.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserDTO(@NotBlank String login, @NotBlank String password) {
}
