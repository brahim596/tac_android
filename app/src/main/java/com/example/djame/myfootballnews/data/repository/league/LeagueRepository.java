package com.example.djame.myfootballnews.data.repository.league;

import com.example.djame.myfootballnews.data.api.model.league.LeagueResponse;

import io.reactivex.Single;

public interface LeagueRepository {

    Single<LeagueResponse> getLeagueById(String leagueId, String apiKey);
}
