package com.example.djame.myfootballnews.data.repository.player;

import com.example.djame.myfootballnews.data.api.model.player.PlayerResponse;
import com.example.djame.myfootballnews.data.repository.player.remote.PlayerRemoteDataSource;

import io.reactivex.Single;

public class PlayerDataRepository implements PlayerRepository{

    private PlayerRemoteDataSource playerRemoteDataSource;

    public PlayerDataRepository(PlayerRemoteDataSource playerRemoteDataSource) {
        this.playerRemoteDataSource = playerRemoteDataSource;
    }

    @Override
    public Single<PlayerResponse> searchPlayerByName(String name, String apiKey) {
        return this.playerRemoteDataSource.searchPlayerByName(name,apiKey);
    }
}
