package com.example.ballit;

import com.example.ballit.model.Championship;
import com.example.ballit.model.Team;
import com.example.ballit.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class BallitChampionshipApplication implements CommandLineRunner {

	@Autowired
	private TeamService teamService;

	public static void main(String[] args) {
		SpringApplication.run(BallitChampionshipApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the Ballit Championship!");

		// Fetching teams
		List<Team> teams = teamService.getAllTeams();

		if (teams.isEmpty()) {
			System.out.println("No teams found. Please register teams using the API.");
			return;
		}

		// Displaying teams
		System.out.println("Teams fetched:");
		for (Team team : teams) {
			System.out.println(team.getName() + " (" + team.getId() + ")");
		}

		// Starting the championship
		try {
			Championship championship = new Championship(teams);
			championship.start();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Thank you for participating in the Ballit Championship!");
	}
}
