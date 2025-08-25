package com.API.tasks.business.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserDTO( String login, String password) {
}
