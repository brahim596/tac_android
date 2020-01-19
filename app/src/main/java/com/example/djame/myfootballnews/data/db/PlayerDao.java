package com.example.djame.myfootballnews.data.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.djame.myfootballnews.data.api.model.player.Player;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

@Dao
public interface PlayerDao {

    @Insert
    public Completable insertPlayer(PlayerEntity playerEntity);

    @Query("SELECT * from PlayerEntity")
    Flowable<List<PlayerEntity>> loadFavorites();
}
