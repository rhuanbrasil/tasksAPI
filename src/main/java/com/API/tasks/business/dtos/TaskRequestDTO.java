package com.API.tasks.business.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record TaskRequestDTO(@Size(min = 5, message = "Description size must have at least 5 characters") @NotBlank(message = "this field cannot be null or blank") String description, @NotBlank(message = "this field cannot be null or blank") String status) {
}
