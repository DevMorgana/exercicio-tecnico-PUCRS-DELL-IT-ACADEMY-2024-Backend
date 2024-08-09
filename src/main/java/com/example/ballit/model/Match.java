package com.example.ballit.model;

public class Match {
    private Team teamA;
    private Team teamB;
    private int pointsA;
    private int pointsB;
    private int blotsA;
    private int blotsB;
    private int plifsA;
    private int plifsB;
    private int advrunghsA;
    private int advrunghsB;

    public Match(Team teamA, Team teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.pointsA = 50;
        this.pointsB = 50;
        this.blotsA = 0;
        this.blotsB = 0;
        this.plifsA = 0;
        this.plifsB = 0;
        this.advrunghsA = 0;
        this.advrunghsB = 0;
    }

    public void display() {
        System.out.println(teamA.getName() + " vs " + teamB.getName());
        System.out.println("Points: " + pointsA + " - " + pointsB);
    }

    public void blotA() {
        blotsA++;
        pointsA += 5;
        display();
    }

    public void blotB() {
        blotsB++;
        pointsB += 5;
        display();
    }

    public void plifA() {
        plifsA++;
        pointsA++;
        display();
    }

    public void plifB() {
        plifsB++;
        pointsB++;
        display();
    }

    public void advrunghA() {
        advrunghsA++;
        pointsA -= 10;
        display();
    }

    public void advrunghB() {
        advrunghsB++;
        pointsB -= 10;
        display();
    }

    public void end() {
        System.out.println("Match ended: " + teamA.getName() + " " + pointsA + " - " + pointsB + " " + teamB.getName());
    }

    public Team getWinner() {
        if (pointsA > pointsB) {
            return teamA;
        } else if (pointsB > pointsA) {
            return teamB;
        } else {
            return (Math.random() > 0.5) ? teamA : teamB;
        }
    }

    public Team getTeamA() {
        return teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public int getPointsA() {
        return pointsA;
    }

    public int getPointsB() {
        return pointsB;
    }

    public int getBlotsA() {
        return blotsA;
    }

    public int getBlotsB() {
        return blotsB;
    }

    public int getPlifsA() {
        return plifsA;
    }

    public int getPlifsB() {
        return plifsB;
    }

    public int getAdvrunghsA() {
        return advrunghsA;
    }

    public int getAdvrunghsB() {
        return advrunghsB;
    }
}
