package com.example.djame.myfootballnews.data.repository.league;

import com.example.djame.myfootballnews.data.api.model.LeagueDisplayService;
import com.example.djame.myfootballnews.data.api.model.league.LeagueResponse;
import com.example.djame.myfootballnews.data.repository.league.remote.LeagueRemoteDataSource;

import io.reactivex.Single;

public class LeagueDataRepository implements LeagueRepository {

    private LeagueRemoteDataSource leagueRemoteDataSource;

    public LeagueDataRepository(LeagueRemoteDataSource leagueRemoteDataSource) {
        this.leagueRemoteDataSource = leagueRemoteDataSource;
    }

    @Override
    public Single<LeagueResponse> getLeagueById(String leagueId, String apiKey) {
        return this.leagueRemoteDataSource.getLeagueResponse(leagueId,apiKey);
    }

    @Override
    public Single<LeagueResponse> getCurrentSeasonsFromLeaguesByCountry(String country, String apiKey) {
        return this.leagueRemoteDataSource.getCurrentSeasonsFromLeaguesByCountry(country,apiKey);
    }
}
