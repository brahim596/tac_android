package com.example.djame.myfootballnews.presentation.playerDisplay.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.djame.myfootballnews.R;
import com.example.djame.myfootballnews.data.api.model.player.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerViewHolder> {

    List<Player> players;

    public PlayerAdapter() {
        this.players = new ArrayList<>();
    }

    public void bindViewModels(List<Player> players){
        this.players=players;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PlayerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.player_item,parent,false));
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
