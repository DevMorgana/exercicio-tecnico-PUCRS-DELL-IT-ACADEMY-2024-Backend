package com.example.ballit.controller;

import com.example.ballit.model.Team;
import com.example.ballit.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private TeamService service;

    @PostMapping("/{register}")
    public Team registerTeam(@RequestBody Team response) {
        return service.createTeam(response);
    }

    @GetMapping
    public List<Team> findAllTeams() {
        return service.getAllTeams();
    }
}
