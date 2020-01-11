package com.example.djame.myfootballnews.data.api.model;

import com.example.djame.myfootballnews.data.api.model.league.LeagueResponse;
import com.example.djame.myfootballnews.data.api.model.standings.Standing;
import com.example.djame.myfootballnews.data.api.model.standings.StandingResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StandingDisplayService {

    @GET("leagueTable/{leagueId}")
    @Headers({
            "x-rapidapi-host: api-football-v1.p.rapidapi.com",
            "x-rapidapi-key: 0b7833025emsh727af8e17b15433p1773dbjsndcee749125ca"
    })
    Single<StandingResponse> getStandingByLeagueId(@Path("leagueId") String leagueId, @Query("apiKey") String apiKey);

}
