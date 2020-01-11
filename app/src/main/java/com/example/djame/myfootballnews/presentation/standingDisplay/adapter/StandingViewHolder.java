package com.example.djame.myfootballnews.presentation.standingDisplay.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.djame.myfootballnews.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StandingViewHolder extends RecyclerView.ViewHolder {

    private View view;

    private ImageView logo;

    private TextView rank;
    private TextView teamName;
    private TextView gamesPlayed;
    private TextView win;
    private TextView draw;
    private TextView loose;
    private TextView goalsFor;
    private TextView goalsAgainst;
    private TextView goalsDiff;
    private TextView points;
    private TextView form;


    public StandingViewHolder(@NonNull View itemView) {
        super(itemView);
        view=itemView;
        logo=view.findViewById(R.id.logo);
        rank=view.findViewById(R.id.rank);
        teamName=view.findViewById(R.id.teamName);
        gamesPlayed=view.findViewById(R.id.gamesPlayed);
        win=view.findViewById(R.id.win);
        draw=view.findViewById(R.id.draw);
        loose=view.findViewById(R.id.loose);
        goalsFor=view.findViewById(R.id.goalsFor);
        goalsAgainst=view.findViewById(R.id.goalsAgainst);
        goalsDiff=view.findViewById(R.id.goalsDiff);
        points=view.findViewById(R.id.points);
       // form=view.findViewById(R.id.forme);
    }


    public void bindViewModel(StandingItemViewModel standingItemViewModel){

        rank.setText(""+standingItemViewModel.getRank());
        teamName.setText(standingItemViewModel.getTeamName());
        gamesPlayed.setText(""+standingItemViewModel.getNbGamesPlayed());
        win.setText(""+standingItemViewModel.getAll().getWin());
        draw.setText(""+standingItemViewModel.getAll().getDraw());
        loose.setText(""+standingItemViewModel.getAll().getLose());
        goalsFor.setText(""+standingItemViewModel.getAll().getGoalsFor());
        goalsAgainst.setText(""+standingItemViewModel.getAll().getGoalsAgainst());
        goalsDiff.setText(""+standingItemViewModel.getGoalsDiff());
        points.setText(""+standingItemViewModel.getPoints());
        //form.setText(""+standingItemViewModel.getForme());

        Glide.with(this.view).load(standingItemViewModel.getLogo()).override(60,60).centerCrop().transition(DrawableTransitionOptions.withCrossFade(100)).into(logo);

    }


}
