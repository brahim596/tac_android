package com.example.djame.myfootballnews.data.repository.player.remote;

import com.example.djame.myfootballnews.data.api.model.PlayerDisplayService;
import com.example.djame.myfootballnews.data.api.model.player.PlayerResponse;
import com.example.djame.myfootballnews.data.db.PlayerEntity;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import retrofit2.http.Query;

public class PlayerRemoteDataSource {

    private PlayerDisplayService playerDisplayService;

    public PlayerRemoteDataSource(PlayerDisplayService playerDisplayService) {
        this.playerDisplayService = playerDisplayService;
    }

    public Single<PlayerResponse> searchPlayerByName(String name, String apiKey){
        return this.playerDisplayService.searchPlayerByName(name,apiKey);
    }
}
