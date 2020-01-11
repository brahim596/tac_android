package com.example.djame.myfootballnews.data.api.model.standings;

import java.util.Date;

public class Standing {

    int rank;
    String team_id;
    String teamName;
    String logo;
    String group;
    String forme;
    Performence all;
    Performence home;
    Performence away;
    int goalsDiff;
    int points;
    Date lastUpdate;


    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getForme() {
        return forme;
    }

    public void setForme(String forme) {
        this.forme = forme;
    }

    public Performence getAll() {
        return all;
    }

    public void setAll(Performence all) {
        this.all = all;
    }

    public Performence getHome() {
        return home;
    }

    public void setHome(Performence home) {
        this.home = home;
    }

    public Performence getAway() {
        return away;
    }

    public void setAway(Performence away) {
        this.away = away;
    }

    public int getGoalsDiff() {
        return goalsDiff;
    }

    public void setGoalsDiff(int goalsDiff) {
        this.goalsDiff = goalsDiff;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
