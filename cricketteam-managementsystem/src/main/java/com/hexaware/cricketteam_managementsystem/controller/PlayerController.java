package com.hexaware.cricketteam_managementsystem.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cricketteam_managementsystem.dto.PlayerDto;
import com.hexaware.cricketteam_managementsystem.service.IPlayerService;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import lombok.*;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
@Slf4j
public class PlayerController {

	
	private final IPlayerService service;
	
	
	@GetMapping("/search")
	public ResponseEntity<List<PlayerDto>> findByPlayerName(@RequestParam String playerName) {
	    log.info("Find players by name: {}", playerName);
	    return ResponseEntity.ok(service.findByPlayerName(playerName));
	}


    @PostMapping 
    public ResponseEntity<PlayerDto> create(@Valid @RequestBody PlayerDto dto) {
        log.info("Create player: {}", dto.getPlayerName());
        PlayerDto created = service.createPlayer(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDto> getById(@PathVariable Long id) {
        log.info("Get player by id: {}", id);
        PlayerDto dto = service.getPlayerById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<PlayerDto>> getAll(@RequestParam(required = false) String team,
                                                  @RequestParam(required = false) String role) {
        log.info("Get all players (team={}, role={})", team, role);
        if (team != null) {
            return ResponseEntity.ok(service.findByTeam(team));
        } else if (role != null) {
            return ResponseEntity.ok(service.findByRole(role));
        } else {
            return ResponseEntity.ok(service.getAllPlayers());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerDto> update(@PathVariable Long id, @Valid @RequestBody PlayerDto dto) {
        log.info("Update player id: {}", id);
        PlayerDto updated = service.updatePlayer(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("Delete player id: {}", id);
        service.deletePlayer(id);
        return ResponseEntity.noContent().build();
    }
}
