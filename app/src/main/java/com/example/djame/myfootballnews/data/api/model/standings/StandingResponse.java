package com.example.djame.myfootballnews.data.api.model.standings;

import com.google.gson.annotations.SerializedName;

public class StandingResponse {

    @SerializedName("api")
    StandingBody api;

    public StandingBody getApi() {
        return api;
    }

    public void setApi(StandingBody api) {
        this.api = api;
    }
}
