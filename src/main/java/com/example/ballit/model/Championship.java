package com.example.ballit.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Championship {
    private List<Team> teams;
    private List<Match> currentMatches;
    private int round;

    public Championship(List<Team> teams) {
        if (teams.size() < 8 || teams.size() > 16 || teams.size() % 2 != 0) {
            throw new IllegalArgumentException("O campeonato deve ter entre 8 e 16 times, e o número de times deve ser par.");
        }
        this.teams = teams;
        this.currentMatches = new ArrayList<>();
        this.round = 1;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (teams.size() > 1) {
            System.out.println("==== Round " + round + " ====");
            shuffleTeams();
            createMatches();
            playMatches(scanner);
            round++;
        }
        System.out.println("==== Champion ====");
        Team champion = teams.get(0);
        System.out.println("Champion: " + champion.getName());
        System.out.println("War Cry: " + champion.getWarCry());
        displayFinalTable();
    }

    private void shuffleTeams() {
        Collections.shuffle(teams);
    }

    private void createMatches() {
        currentMatches.clear();
        for (int i = 0; i < teams.size() - 1; i += 2) {
            Match match = new Match(teams.get(i), teams.get(i + 1));
            currentMatches.add(match);
        }
    }

    public void playMatches(Scanner scanner) {
        for (Match match : currentMatches) {
            match.display();
            boolean finished = false;
            while (!finished) {
                System.out.println("1: Blot Team A, 2: Blot Team B, 3: Plif Team A, 4: Plif Team B, 5: Encerrar Partida, 6: Advrungh Team A, 7: Advrungh Team B");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        match.blotA();
                        break;
                    case 2:
                        match.blotB();
                        break;
                    case 3:
                        match.plifA();
                        break;
                    case 4:
                        match.plifB();
                        break;
                    case 5:
                        match.end();
                        finished = true;
                        break;
                    case 6:
                        match.advrunghA();
                        break;
                    case 7:
                        match.advrunghB();
                        break;
                    default:
                        System.out.println("Escolha inválida");
                }

                if (Math.abs(match.getPointsA() - match.getPointsB()) >= 10) {
                    System.out.println("Diferença de 10 pontos atingida, encerrando a partida.");
                    match.end();
                    finished = true;
                }
            }
        }
        teams = new ArrayList<>();
        for (Match match : currentMatches) {
            teams.add(match.getWinner());
        }
    }

    private void displayFinalTable() {
        System.out.println("==== Final Table ====");
        System.out.printf("%-20s %-10s %-10s %-10s %-10s\n", "Team", "Blots", "Plifs", "Advrunghs", "Points");
        for (Match match : currentMatches) {
            Team teamA = match.getTeamA();
            Team teamB = match.getTeamB();
            System.out.printf("%-20s %-10d %-10d %-10d %-10d\n", teamA.getName(), match.getBlotsA(), match.getPlifsA(), match.getAdvrunghsA(), match.getPointsA());
            System.out.printf("%-20s %-10d %-10d %-10d %-10d\n", teamB.getName(), match.getBlotsB(), match.getPlifsB(), match.getAdvrunghsB(), match.getPointsB());
        }
    }
}
