package com.example.djame.myfootballnews.data.api.model.player;

import com.example.djame.myfootballnews.data.api.model.league.League;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlayerBody {

    int results;

    @SerializedName("leagues")
    List<Player> players;

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
