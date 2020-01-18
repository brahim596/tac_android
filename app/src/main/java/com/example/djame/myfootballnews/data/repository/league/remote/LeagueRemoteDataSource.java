package com.example.djame.myfootballnews.data.repository.league.remote;

import com.example.djame.myfootballnews.data.api.model.LeagueDisplayService;
import com.example.djame.myfootballnews.data.api.model.league.LeagueResponse;

import io.reactivex.Single;

public class LeagueRemoteDataSource {

    private LeagueDisplayService leagueDisplayService;

    public LeagueRemoteDataSource(LeagueDisplayService leagueDisplayService) {
        this.leagueDisplayService = leagueDisplayService;
    }

    public Single<LeagueResponse> getLeagueResponse(String leagueId, String apiKey){
        return this.leagueDisplayService.getLeagueById(leagueId,apiKey);
    }

    public Single<LeagueResponse> getCurrentSeasonsFromLeaguesByCountry(String country, String apiKey){
        return this.leagueDisplayService.getCurrentSeasonsFromLeaguesByCountry(country,apiKey);
    }


}
