package com.example.djame.myfootballnews.data.repository.player;

import com.example.djame.myfootballnews.data.api.model.player.Player;
import com.example.djame.myfootballnews.data.api.model.player.PlayerResponse;
import com.example.djame.myfootballnews.data.db.PlayerEntity;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import retrofit2.http.Query;

public interface PlayerRepository {
    Single<PlayerResponse> searchPlayerByName(String name, String apiKey);

    void insertPlayerLocalDatabase(Player player);

    Flowable<List<PlayerEntity>> loadFavoritedPlayer();
}
