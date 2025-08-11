package com.hexaware.cricketteam_managementsystem.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PlayerDto {

	private Long playerId;

    @NotBlank(message = "Player name is required")
    private String playerName;

    @NotNull(message = "Jersey number is required")
    @Min(value = 0, message = "Jersey number must be >= 0")
    private Integer jerseyNumber;

    @NotBlank(message = "Role is required")
    private String role;

    @Min(value = 0, message = "Total matches must be >= 0")
    private Integer totalMatches;

    private String teamName;

    private String country;

    @Size(max = 2000, message = "Description can't exceed 2000 characters")
    private String description;
}
