package com.example.djame.myfootballnews.presentation.leaguedisplay.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LeagueViewHolder extends RecyclerView.ViewHolder {

    View view;
    TextView title;
    ImageView logo;
    LeagueItemViewModel leagueItemViewModel;

    public LeagueViewHolder(@NonNull View itemView) {
        super(itemView);
        this.view = itemView;
    }

    public void bindViewModel(LeagueItemViewModel leagueItemViewModel){
        this.leagueItemViewModel = leagueItemViewModel;
        title.setText(leagueItemViewModel.getName());
    }
}
