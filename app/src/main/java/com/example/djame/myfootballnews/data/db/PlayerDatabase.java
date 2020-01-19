package com.example.djame.myfootballnews.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {PlayerEntity.class}, version = 1)
public abstract class PlayerDatabase extends RoomDatabase {
    public abstract PlayerDao playerDao();
}
