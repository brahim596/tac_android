package com.example.djame.myfootballnews.presentation.leaguedisplay.adapter;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.djame.myfootballnews.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LeagueAdapter extends RecyclerView.Adapter<LeagueViewHolder> {

    private List<LeagueItemViewModel> leagueItemViewModels;

    public LeagueAdapter() {
        this.leagueItemViewModels = new ArrayList<>();
    }

    public void bindViewModels(List<LeagueItemViewModel> leagueItemViewModels){
        this.leagueItemViewModels.clear();
        this.leagueItemViewModels=leagueItemViewModels;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LeagueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LeagueViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.league_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LeagueViewHolder holder, int position) {
        holder.bindViewModel(this.leagueItemViewModels.get(position));
    }

    @Override
    public int getItemCount() {
        return this.leagueItemViewModels.size();
    }
}
