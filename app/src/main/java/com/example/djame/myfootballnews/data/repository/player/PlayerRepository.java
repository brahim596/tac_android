package com.example.djame.myfootballnews.data.repository.player;

import com.example.djame.myfootballnews.data.api.model.player.PlayerResponse;

import io.reactivex.Single;
import retrofit2.http.Query;

public interface PlayerRepository {
    Single<PlayerResponse> searchPlayerByName(String name, String apiKey);
}
