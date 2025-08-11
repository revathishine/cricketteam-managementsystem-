package com.hexaware.cricketteam_managementsystem.entity;
//date 11/8/25
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import lombok.*;

@Entity
@Table(name = "players")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long playerId;

	    @Column(nullable = false)
	    private String playerName;

	    @Column(nullable = false)
	    private Integer jerseyNumber;

	    @Column(nullable = false)
	    private String role; // e.g., Batsman, Bowler, Keeper, All Rounder

	    private Integer totalMatches;

	    private String teamName;

	    private String country;

	    @Column(length = 2000)
	    private String description;
}
