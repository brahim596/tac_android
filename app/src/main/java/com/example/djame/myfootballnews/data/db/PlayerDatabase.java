package com.example.djame.myfootballnews.data.db;

import androidx.room.Database;

import com.example.djame.myfootballnews.data.api.model.player.Player;

@Database(entities = {Player.class}, version = 1)
public abstract class PlayerDatabase {
    public abstract PlayerDao playerDao();
}
