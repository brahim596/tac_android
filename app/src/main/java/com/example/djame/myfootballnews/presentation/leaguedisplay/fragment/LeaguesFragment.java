package com.example.djame.myfootballnews.presentation.leaguedisplay.fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.djame.myfootballnews.DependencyInjection;
import com.example.djame.myfootballnews.R;
import com.example.djame.myfootballnews.presentation.leaguedisplay.LeagueContractView;
import com.example.djame.myfootballnews.presentation.leaguedisplay.LeaguePresenter;
import com.example.djame.myfootballnews.presentation.leaguedisplay.adapter.LeagueAdapter;
import com.example.djame.myfootballnews.presentation.leaguedisplay.adapter.LeagueItemViewModel;

import java.util.List;


public class LeaguesFragment extends Fragment implements LeagueContractView {


    private View view;
    private EditText searchLeagueEditText;
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
        searchLeagueEditText= view.findViewById(R.id.searcheLeagueEditText);
        searchLeagueEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                leagueAdapter.filterByLeagueName(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
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

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        int currentOrientation = getResources().getConfiguration().orientation;
        if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(),2));
        }
        else {
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        }
    }

    public void setUpRecyclerView(){
        leagueAdapter= new LeagueAdapter();
        recyclerView = view.findViewById(R.id.listLeagues);
        recyclerView.setAdapter(leagueAdapter);
        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(),2));
        }
        else{
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        }
    }


    @Override
    public void displayLeagues(List<LeagueItemViewModel> leagueItemViewModels) {
        leagueAdapter.bindViewModels(leagueItemViewModels);
    }
}
