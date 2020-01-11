package com.example.djame.myfootballnews.data.repository.standing;

import com.example.djame.myfootballnews.data.api.model.standings.StandingResponse;

import io.reactivex.Single;

public interface StandingRepository {

    Single<StandingResponse> getStandingByLeagueId(String leagueId, String apiKey);
}
