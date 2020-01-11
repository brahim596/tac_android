package com.example.djame.myfootballnews.presentation.standingDisplay.adapter;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.djame.myfootballnews.R;
import com.example.djame.myfootballnews.presentation.leaguedisplay.adapter.LeagueViewHolder;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StandingAdapter extends RecyclerView.Adapter<StandingViewHolder> {

    private List<StandingItemViewModel> standingItemViewModels;

    public StandingAdapter() {
        this.standingItemViewModels = new ArrayList<>();
    }


    public void bindViewModels(List<StandingItemViewModel> standingItemViewModels){
        this.standingItemViewModels.clear();
        this.standingItemViewModels=standingItemViewModels;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StandingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StandingViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.standing_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StandingViewHolder holder, int position) {
        holder.bindViewModel(this.standingItemViewModels.get(position));
    }

    @Override
    public int getItemCount() {
        return this.standingItemViewModels.size();
    }
}
