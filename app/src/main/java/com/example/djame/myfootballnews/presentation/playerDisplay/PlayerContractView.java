package com.example.djame.myfootballnews.presentation.playerDisplay;

import com.example.djame.myfootballnews.data.api.model.player.Player;

import java.util.List;

public interface PlayerContractView {

    void displayPlayers(List<Player> playerList);

    void displayFavoritesPlayers(List<Player> playerList);

    void addFavorite(Player player);
}
