package com.example.djame.myfootballnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.djame.myfootballnews.presentation.leaguedisplay.LeagueContractView;
import com.example.djame.myfootballnews.presentation.leaguedisplay.LeaguePresenter;
import com.example.djame.myfootballnews.presentation.leaguedisplay.adapter.LeagueAdapter;
import com.example.djame.myfootballnews.presentation.leaguedisplay.adapter.LeagueItemViewModel;

import java.util.List;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity implements LeagueContractView {

    private RecyclerView recyclerView;
    private LeagueAdapter leagueAdapter;
    private LeaguePresenter leaguePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leagueAdapter= new LeagueAdapter();
        recyclerView = findViewById(R.id.listLeagues);
        leaguePresenter = new LeaguePresenter(DependencyInjection.getLeagueRepository());
        leaguePresenter.bindView(this);
        recyclerView.setAdapter(leagueAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        leaguePresenter.getLeagues();

    }

    @Override
    public void displayLeagues(List<LeagueItemViewModel> leagueItemViewModels) {
        leagueAdapter.bindViewModels(leagueItemViewModels);
    }
}
