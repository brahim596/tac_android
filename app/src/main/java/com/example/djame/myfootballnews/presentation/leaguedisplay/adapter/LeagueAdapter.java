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
    private List<LeagueItemViewModel> backupLeagueItemViewModels;

    public LeagueAdapter() {

        this.leagueItemViewModels = new ArrayList<>();
        this.backupLeagueItemViewModels = new ArrayList<>();
    }

    public void bindViewModels(List<LeagueItemViewModel> leaguesItems){
        this.leagueItemViewModels.clear();
        this.backupLeagueItemViewModels.clear();
        this.leagueItemViewModels.addAll(leaguesItems);
        this.backupLeagueItemViewModels.addAll(leaguesItems);
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

    public void filterByLeagueName(String leagueName){
        this.leagueItemViewModels.clear();

        //Impossible d'utiliser les stream ...
        for(LeagueItemViewModel leagueItemViewModel: this.backupLeagueItemViewModels)
            if(leagueItemViewModel.getName().toLowerCase().contains(leagueName.toLowerCase()))
                this.leagueItemViewModels.add(leagueItemViewModel);
        this.notifyDataSetChanged();
    }
}
