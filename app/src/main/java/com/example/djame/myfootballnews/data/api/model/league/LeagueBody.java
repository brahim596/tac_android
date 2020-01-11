package com.example.djame.myfootballnews.data.api.model.league;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LeagueBody {

    int results;

    @SerializedName("leagues")
    List<League> leagues;

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }

    public List<League> getLeagues() {
        return leagues;
    }

    public void setLeagues(List<League> leagues) {
        this.leagues = leagues;
    }
}
