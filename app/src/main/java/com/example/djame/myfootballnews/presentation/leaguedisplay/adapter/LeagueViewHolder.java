package com.example.djame.myfootballnews.presentation.leaguedisplay.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.djame.myfootballnews.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LeagueViewHolder extends RecyclerView.ViewHolder {

    View view;
    TextView league_name;
    TextView league_country;
    ImageView league_icon;
    LeagueItemViewModel leagueItemViewModel;

    public LeagueViewHolder(View itemView) {
        super(itemView);
        this.view = itemView;
        league_name = itemView.findViewById(R.id.league_name);
        league_country = itemView.findViewById(R.id.league_country);
        league_icon = itemView.findViewById(R.id.league_icon);
    }

    public void bindViewModel(LeagueItemViewModel leagueItemViewModel){
        this.leagueItemViewModel = leagueItemViewModel;
        league_name.setText(leagueItemViewModel.getName());
        league_country.setText(leagueItemViewModel.getCountry());
        Glide.with(this.view).load(this.leagueItemViewModel.getUrlLogo()).centerCrop().transition(DrawableTransitionOptions.withCrossFade(100)).circleCrop().into(league_icon);
    }
}
