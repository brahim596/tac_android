package com.example.djame.myfootballnews.presentation.leaguedisplay.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.djame.myfootballnews.R;
import com.example.djame.myfootballnews.presentation.standingDisplay.StandingActivity;

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

    public void bindViewModel(LeagueItemViewModel leagueItemViewModel,int position){
        this.leagueItemViewModel = leagueItemViewModel;
        league_name.setText(leagueItemViewModel.getName());
        league_country.setText(leagueItemViewModel.getCountry());
        Glide.with(this.view).load(this.leagueItemViewModel.getUrlLogo()).fitCenter().transition(DrawableTransitionOptions.withCrossFade(100)).into(league_icon);
        setupListener();
    }

    public void setupListener(){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(view.getContext(),leagueItemViewModel.getName(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(view.getContext(), StandingActivity.class);
                intent.putExtra("LEAGUE_ID", ""+leagueItemViewModel.getId());
                view.getContext().startActivity(intent);
            }
        });
    }

}
