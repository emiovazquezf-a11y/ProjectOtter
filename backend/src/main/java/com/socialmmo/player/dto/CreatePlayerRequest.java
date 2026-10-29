
package com.socialmmo.player.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreatePlayerRequest(
    @NotBlank
    @Pattern(regexp = "\\d{17}", message = "Steam ID must contain exactly 17 digits")
    String steamId,

    @NotBlank
    @Size(min = 3, max = 32)
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username may only contain letters, numbers, and underscores")
    String username
) {}

