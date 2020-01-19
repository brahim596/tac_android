package com.example.djame.myfootballnews.data.repository.player;

import com.example.djame.myfootballnews.data.api.model.player.Player;
import com.example.djame.myfootballnews.data.api.model.player.PlayerResponse;
import com.example.djame.myfootballnews.data.db.PlayerEntity;
import com.example.djame.myfootballnews.data.repository.player.locale.PlayerLocaleDataSource;
import com.example.djame.myfootballnews.data.repository.player.remote.PlayerRemoteDataSource;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public class PlayerDataRepository implements PlayerRepository{

    private PlayerRemoteDataSource playerRemoteDataSource;
    private PlayerLocaleDataSource playerLocaleDataSource;

    public PlayerDataRepository(PlayerRemoteDataSource playerRemoteDataSource, PlayerLocaleDataSource playerLocaleDataSource) {
        this.playerRemoteDataSource = playerRemoteDataSource;
        this.playerLocaleDataSource = playerLocaleDataSource;
    }

    @Override
    public Single<PlayerResponse> searchPlayerByName(String name, String apiKey) {
        return this.playerRemoteDataSource.searchPlayerByName(name,apiKey);
    }

    public void insertPlayerLocalDatabase(Player player){
        this.playerLocaleDataSource.insertPlayer(mapPlayerToPlayerEntity(player));
    }

    public Flowable<List<PlayerEntity>> loadFavoritedPlayer(){
        return this.playerLocaleDataSource.loadFavorites();
    }

    private PlayerEntity mapPlayerToPlayerEntity(Player player){
        return new PlayerEntity(player.getPlayer_id(),player.getPlayer_name(),player.getFirstname(),player.getLastname(),player.getNumber(),player.getPosition(),player.getAge(),player.getNationality(),player.getHeight(),player.getWeight());
    }

    public static Player mapPlayerEntityToPlayer(PlayerEntity player){
        return new Player(player.getPlayer_id(),player.getPlayer_name(),player.getFirstname(),player.getLastname(),player.getNumber(),player.getPosition(),player.getAge(),player.getNationality(),player.getHeight(),player.getWeight());
    }
}
