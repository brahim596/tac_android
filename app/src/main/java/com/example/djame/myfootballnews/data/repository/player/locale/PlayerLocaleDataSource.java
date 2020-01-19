package com.example.djame.myfootballnews.data.repository.player.locale;

import com.example.djame.myfootballnews.data.db.PlayerDatabase;
import com.example.djame.myfootballnews.data.db.PlayerEntity;

import java.util.List;

import io.reactivex.Flowable;

public class PlayerLocaleDataSource {

    private PlayerDatabase playerDatabase;

    public PlayerLocaleDataSource(PlayerDatabase playerDatabase) {
        this.playerDatabase = playerDatabase;
    }

    public void insertPlayer(PlayerEntity playerEntity){
        playerDatabase.playerDao().insertPlayer(playerEntity);
    }

    public Flowable<List<PlayerEntity>> loadFavorites(){
        return this.playerDatabase.playerDao().loadFavorites();
    }
}
