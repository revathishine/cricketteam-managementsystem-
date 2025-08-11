package com.hexaware.cricketteam_managementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.cricketteam_managementsystem.entity.Player;

@Repository
public interface PlayerRepository  extends JpaRepository<Player, Long> {

	List<Player> findByTeamNameIgnoreCase(String teamName);
    List<Player> findByRoleIgnoreCase(String role);
    List<Player> findByPlayerNameIgnoreCase(String playerName);

}
