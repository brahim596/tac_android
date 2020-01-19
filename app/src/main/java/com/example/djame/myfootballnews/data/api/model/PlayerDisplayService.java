package com.example.djame.myfootballnews.data.api.model;

import com.example.djame.myfootballnews.data.api.model.player.PlayerResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PlayerDisplayService {

    @GET("players/search/{name}")
    @Headers({
            "x-rapidapi-host: api-football-v1.p.rapidapi.com",
            "x-rapidapi-key: 0b7833025emsh727af8e17b15433p1773dbjsndcee749125ca"
    })
    Single<PlayerResponse> searchPlayerByName(@Path("name") String name, @Query("apiKey") String apiKey);
}
