package com.hexaware.cricketteam_managementsystem.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


import com.hexaware.cricketteam_managementsystem.dto.PlayerDto;
import com.hexaware.cricketteam_managementsystem.entity.Player;
import com.hexaware.cricketteam_managementsystem.exception.ResourceNotFoundException;
import com.hexaware.cricketteam_managementsystem.repository.PlayerRepository;
import com.hexaware.cricketteam_managementsystem.service.IPlayerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import lombok.*;
@Service
@RequiredArgsConstructor
@Slf4j
public class PlayerServiceImpl implements IPlayerService  {

	
	private final PlayerRepository repo;

    // map DTO -> Entity
    private Player toEntity(PlayerDto dto) {
        return Player.builder()
                .playerId(dto.getPlayerId())
                .playerName(dto.getPlayerName())
                .jerseyNumber(dto.getJerseyNumber())
                .role(dto.getRole())
                .totalMatches(dto.getTotalMatches())
                .teamName(dto.getTeamName())
                .country(dto.getCountry())
                .description(dto.getDescription())
                .build();
    }

    // map Entity -> DTO
    private PlayerDto toDto(Player p) {
        return PlayerDto.builder()
                .playerId(p.getPlayerId())
                .playerName(p.getPlayerName())
                .jerseyNumber(p.getJerseyNumber())
                .role(p.getRole())
                .totalMatches(p.getTotalMatches())
                .teamName(p.getTeamName())
                .country(p.getCountry())
                .description(p.getDescription())
                .build();
    }

    @Override
    public PlayerDto createPlayer(PlayerDto dto) {
        Player saved = repo.save(toEntity(dto));
        log.debug("Created player: {}", saved.getPlayerId());
        return toDto(saved);
    }

    @Override
    public PlayerDto updatePlayer(Long id, PlayerDto dto) {
        Player existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found with id: " + id));
        // update only allowed fields from dto
        existing.setPlayerName(dto.getPlayerName());
        existing.setJerseyNumber(dto.getJerseyNumber());
        existing.setRole(dto.getRole());
        existing.setTotalMatches(dto.getTotalMatches());
        existing.setTeamName(dto.getTeamName());
        existing.setCountry(dto.getCountry());
        existing.setDescription(dto.getDescription());
        Player saved = repo.save(existing);
        log.debug("Updated player: {}", saved.getPlayerId());
        return toDto(saved);
    }

    @Override
    public PlayerDto getPlayerById(Long id) {
        Player p = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found with id: " + id));
        return toDto(p);
    }

    @Override
    public List<PlayerDto> getAllPlayers() {
        return repo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public void deletePlayer(Long id) {
        Player p = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found with id: " + id));
        repo.delete(p);
        log.debug("Deleted player: {}", id);
    }

    @Override
    public List<PlayerDto> findByTeam(String teamName) {
        return repo.findByTeamNameIgnoreCase(teamName).stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<PlayerDto> findByRole(String role) {
        return repo.findByRoleIgnoreCase(role).stream().map(this::toDto).collect(Collectors.toList());
    }
}
