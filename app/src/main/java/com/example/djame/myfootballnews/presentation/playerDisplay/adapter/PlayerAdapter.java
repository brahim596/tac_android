package com.example.djame.myfootballnews.presentation.playerDisplay.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.djame.myfootballnews.R;
import com.example.djame.myfootballnews.data.api.model.player.Player;
import com.example.djame.myfootballnews.presentation.playerDisplay.PlayerContractView;

import java.util.ArrayList;
import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerViewHolder> {

    private List<Player> players;
    private PlayerContractView playerContractView;

    public PlayerAdapter(PlayerContractView playerContractView) {
        this.players = new ArrayList<>();
        this.playerContractView = playerContractView;
    }

    public void bindViewModels(List<Player> players){
        this.players=players;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PlayerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.player_item,parent,false),playerContractView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        holder.bindViewModel(this.players.get(position));
    }

    @Override
    public int getItemCount() {
        return this.players.size();
    }


}
