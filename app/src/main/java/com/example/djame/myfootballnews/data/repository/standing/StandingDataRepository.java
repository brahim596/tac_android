package com.example.djame.myfootballnews.data.repository.standing;

import com.example.djame.myfootballnews.data.api.model.standings.StandingResponse;
import com.example.djame.myfootballnews.data.repository.standing.remote.StandingRemoteDataSource;

import io.reactivex.Single;

public class StandingDataRepository implements StandingRepository {

    private StandingRemoteDataSource standingRemoteDataSource;

    public StandingDataRepository(StandingRemoteDataSource standingRemoteDataSource) {
        this.standingRemoteDataSource = standingRemoteDataSource;
    }

    @Override
    public Single<StandingResponse> getStandingByLeagueId(String leagueId, String apiKey) {
        return this.standingRemoteDataSource.getStandingByLeagueId(leagueId,apiKey);
    }
}
