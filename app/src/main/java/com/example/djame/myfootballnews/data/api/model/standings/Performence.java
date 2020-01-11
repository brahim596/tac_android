package com.example.djame.myfootballnews.data.api.model.standings;

public class Performence {

    int matchsPlayes;
    int win;
    int draw;
    int lose;
    int goalsFor;
    int goalsAgainst;

    public int getMatchsPlayes() {
        return matchsPlayes;
    }

    public void setMatchsPlayes(int matchsPlayes) {
        this.matchsPlayes = matchsPlayes;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }
}
