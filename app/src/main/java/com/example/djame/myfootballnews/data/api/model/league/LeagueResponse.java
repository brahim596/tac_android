package com.example.djame.myfootballnews.data.api.model.league;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LeagueResponse {

    @SerializedName("api")
    LeagueBody leagueBody;

    public LeagueBody getLeagueBody() {
        return leagueBody;
    }

    public void setLeagueBody(LeagueBody leagueBody) {
        this.leagueBody = leagueBody;
    }
}
