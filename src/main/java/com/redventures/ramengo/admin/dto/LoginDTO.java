package com.redventures.ramengo.admin.dto;

import jakarta.validation.constraints.NotEmpty;

public record LoginDTO(@NotEmpty(message = "Mandatory field") String email, @NotEmpty(message = "Mandatory field") String password) {
}
