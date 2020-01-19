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

public class PlayerFragment extends Fragment implements PlayerContractView {

    private PlayerAdapter playerAdapter;
    private PlayerPresenter playerPresenter;
    private RecyclerView recyclerView;
    private EditText searchPlayer;
    private Button valid_searchPlayer;
    private View currentView;


    public PlayerFragment() {}

    public static PlayerFragment newInstance() {
        return new PlayerFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        currentView=inflater.inflate(R.layout.fragment_players, container, false);
        searchPlayer=currentView.findViewById(R.id.search_player);
        valid_searchPlayer=currentView.findViewById(R.id.valid_search_player);
        return currentView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        playerPresenter=new PlayerPresenter(DependencyInjection.getPlayerRepository(),this);
        playerPresenter.bindView(this);
        setupRecyclerView();
        setupSearchPlayerListener();


    }

    private void setupRecyclerView(){
        playerAdapter=new PlayerAdapter();
        recyclerView=currentView.findViewById(R.id.result_search_player);
        recyclerView.setAdapter(playerAdapter);
        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            recyclerView.setLayoutManager(new GridLayoutManager(currentView.getContext(),2));
        }
        else{
            recyclerView.setLayoutManager(new LinearLayoutManager(currentView.getContext()));
        }
    }

    private void setupSearchPlayerListener(){
        this.valid_searchPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String playerNameSearch = searchPlayer.getText().toString();
                if(!playerNameSearch.equals(""))
                    playerPresenter.searchPlayer(playerNameSearch);
            }
        });
    }

    @Override
    public void displayPlayers(List<Player> playerList) {
        this.playerAdapter.bindViewModels(playerList);
    }
}
