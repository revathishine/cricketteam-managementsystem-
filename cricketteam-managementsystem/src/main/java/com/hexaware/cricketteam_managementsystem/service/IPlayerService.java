package com.hexaware.cricketteam_managementsystem.service;

import java.util.List;

import com.hexaware.cricketteam_managementsystem.dto.PlayerDto;

public interface IPlayerService {

	
	PlayerDto createPlayer(PlayerDto dto);
    PlayerDto updatePlayer(Long id, PlayerDto dto);
    PlayerDto getPlayerById(Long id);
    List<PlayerDto> getAllPlayers();
    void deletePlayer(Long id);

    List<PlayerDto> findByTeam(String teamName);
    List<PlayerDto> findByRole(String role);
    List<PlayerDto> findByPlayerName(String playerName);

    
}
