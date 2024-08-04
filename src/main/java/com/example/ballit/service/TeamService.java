package com.example.ballit.service;

import com.example.ballit.model.Team;
import com.example.ballit.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Team createTeam(Team team) {
        if (team.getName() == null || team.getName().isEmpty()) {
            throw new IllegalArgumentException("O nome do time não pode estar vazio.");
        }
        return teamRepository.save(team);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
}
