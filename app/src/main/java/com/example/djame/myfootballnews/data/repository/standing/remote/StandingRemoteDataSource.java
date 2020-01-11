package com.example.djame.myfootballnews.data.repository.standing.remote;
import com.example.djame.myfootballnews.data.api.model.LeagueDisplayService;
import com.example.djame.myfootballnews.data.api.model.StandingDisplayService;
import com.example.djame.myfootballnews.data.api.model.league.LeagueResponse;
import com.example.djame.myfootballnews.data.api.model.standings.StandingResponse;

import io.reactivex.Single;

public class StandingRemoteDataSource {

    private StandingDisplayService standingDisplayService;

    public StandingRemoteDataSource(StandingDisplayService standingDisplayService) {
        this.standingDisplayService = standingDisplayService;
    }

    public Single<StandingResponse> getStandingByLeagueId(String leagueId, String apiKey){
        return this.standingDisplayService.getStandingByLeagueId(leagueId,apiKey);
    }
}
