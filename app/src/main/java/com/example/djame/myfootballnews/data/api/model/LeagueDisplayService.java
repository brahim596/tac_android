package com.example.djame.myfootballnews.data.api.model;

import com.example.djame.myfootballnews.data.api.model.league.LeagueResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LeagueDisplayService {

    @GET("leagues/league/{leagueId}")
    Single<LeagueResponse> searchBooks(@Path("leagueId") String leagueId, @Query("key") String apiKey);

}
