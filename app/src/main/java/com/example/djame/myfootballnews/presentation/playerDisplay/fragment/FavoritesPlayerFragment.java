package com.example.djame.myfootballnews.presentation.playerDisplay.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.djame.myfootballnews.DependencyInjection;
import com.example.djame.myfootballnews.R;
import com.example.djame.myfootballnews.data.api.model.player.Player;
import com.example.djame.myfootballnews.presentation.playerDisplay.PlayerContractView;
import com.example.djame.myfootballnews.presentation.playerDisplay.PlayerPresenter;
import com.example.djame.myfootballnews.presentation.playerDisplay.adapter.PlayerAdapter;

import java.util.List;

public class FavoritesPlayerFragment extends Fragment implements PlayerContractView {

    private PlayerAdapter playerAdapter;
    private PlayerPresenter playerPresenter;
    private RecyclerView recyclerView;
    private View currentView;


    public FavoritesPlayerFragment() {}

    public static FavoritesPlayerFragment newInstance() {
        return new FavoritesPlayerFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        currentView=inflater.inflate(R.layout.fragment_favorites_player, container, false);
        if(playerPresenter!=null)playerPresenter.getFavoritesPlayer();
        return currentView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        playerPresenter=new PlayerPresenter(DependencyInjection.getPlayerRepository(),this);
        playerPresenter.bindView(this);
        setupRecyclerView();
        playerPresenter.getFavoritesPlayer();
    }

    public void setupRecyclerView(){
        playerAdapter=new PlayerAdapter(this);
        recyclerView=currentView.findViewById(R.id.favorite_players);
        recyclerView.setAdapter(playerAdapter);
        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            recyclerView.setLayoutManager(new GridLayoutManager(currentView.getContext(),2));
        }
        else{
            recyclerView.setLayoutManager(new LinearLayoutManager(currentView.getContext()));
        }
    }

    @Override
    public void displayPlayers(List<Player> playerList) {

    }

    @Override
    public void displayFavoritesPlayers(List<Player> playerList) {
        this.playerAdapter.bindViewModels(playerList);
    }

    @Override
    public void addFavorite(Player player) {

    }
}
