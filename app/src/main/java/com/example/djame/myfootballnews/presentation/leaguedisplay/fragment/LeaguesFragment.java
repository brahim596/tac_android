package com.example.djame.myfootballnews.presentation.leaguedisplay.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.djame.myfootballnews.DependencyInjection;
import com.example.djame.myfootballnews.R;
import com.example.djame.myfootballnews.presentation.leaguedisplay.LeagueContractView;
import com.example.djame.myfootballnews.presentation.leaguedisplay.LeaguePresenter;
import com.example.djame.myfootballnews.presentation.leaguedisplay.adapter.LeagueAdapter;
import com.example.djame.myfootballnews.presentation.leaguedisplay.adapter.LeagueItemViewModel;

import java.util.List;


public class LeaguesFragment extends Fragment implements LeagueContractView {


    private View view;
    private RecyclerView recyclerView;
    private LeagueAdapter leagueAdapter;
    private LeaguePresenter leaguePresenter;


    public LeaguesFragment() {
        // Required empty public constructor
    }


    public static LeaguesFragment newInstance() {
        return new LeaguesFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_leagues, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        leaguePresenter = new LeaguePresenter(DependencyInjection.getLeagueRepository());
        leaguePresenter.bindView(this);
        setUpRecyclerView();
        leaguePresenter.getLeagues();
    }

    public void setUpRecyclerView(){
        leagueAdapter= new LeagueAdapter();
        recyclerView = view.findViewById(R.id.listLeagues);
        recyclerView.setAdapter(leagueAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }


    @Override
    public void displayLeagues(List<LeagueItemViewModel> leagueItemViewModels) {
        leagueAdapter.bindViewModels(leagueItemViewModels);
    }
}
