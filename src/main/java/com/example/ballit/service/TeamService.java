package com.example.ballit.service;

import com.example.ballit.model.Team;
import com.example.ballit.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public String startChampionship() {
        List<Team> teams = teamRepository.findAll();
        if (teams.size() < 2) {
            throw new IllegalArgumentException("É necessário ter pelo menos 2 times para iniciar o campeonato.");
        }

        Collections.shuffle(teams);
        List<String> matchups = IntStream.range(0, teams.size() / 2)
                .mapToObj(i -> teams.get(i * 2).getName() + " vs " + teams.get(i * 2 + 1).getName())
                .collect(Collectors.toList());

        return String.join(", ", matchups);
    }
}
