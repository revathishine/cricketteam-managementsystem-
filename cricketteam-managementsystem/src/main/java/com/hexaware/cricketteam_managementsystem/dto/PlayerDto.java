package com.hexaware.cricketteam_managementsystem.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    @Size(min = 5, max = 20, message = "Player name must be between 5 and 20 characters")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]*$", message = "Player name must start with an uppercase letter")
    private String playerName;

    @NotNull(message = "Jersey number is required")
    @Min(value = 0, message = "Jersey number must be >= 0")
    private Integer jerseyNumber;

    @NotBlank(message = "Role is required")
    @Pattern(regexp = "^(Batsman|Bowler|Keeper|All Rounder)$", message = "Role must be one of the following: Batsman, Bowler, Keeper, All Rounder")
    private String role;

    @Min(value = 0, message = "Total matches must be >= 0")
    private Integer totalMatches;

    private String teamName;

    @NotBlank(message = "Country/State name is required")
    @Pattern(regexp = "^[a-zA-Z .'-]+$", message = "Country/State name must contain only letters, spaces, dots, apostrophes, or hyphens")
    private String country;

    @Size(max = 2000, message = "Description can't exceed 2000 characters")
    private String description;
}
