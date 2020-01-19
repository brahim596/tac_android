package com.example.djame.myfootballnews.data.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.djame.myfootballnews.data.api.model.player.Player;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface PlayerDao {

    @Insert
    public void insertPlayer(Player player);

    @Query("SELECT * from PlayerEntity")
    Flowable<List<PlayerEntity>> loadFavorites();
}
