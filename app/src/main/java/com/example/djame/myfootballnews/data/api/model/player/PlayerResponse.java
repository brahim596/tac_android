package com.example.djame.myfootballnews.data.api.model.player;

import com.example.djame.myfootballnews.data.api.model.standings.StandingBody;
import com.google.gson.annotations.SerializedName;

public class PlayerResponse {

    @SerializedName("api")
    PlayerBody api;

    public PlayerBody getApi() {
        return api;
    }

    public void setApi(PlayerBody api) {
        this.api = api;
    }
}
