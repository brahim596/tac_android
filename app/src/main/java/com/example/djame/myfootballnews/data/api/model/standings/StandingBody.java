package com.example.djame.myfootballnews.data.api.model.standings;

import com.example.djame.myfootballnews.data.api.model.league.League;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StandingBody {

    int results;

    @SerializedName("standings")
    List<List<Standing>> standings;

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }

    public List<List<Standing>> getStandings() {
        return standings;
    }

    public void setStandings(List<List<Standing>> standings) {
        this.standings = standings;
    }
}
