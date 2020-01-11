package com.example.djame.myfootballnews.presentation.standingDisplay;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.djame.myfootballnews.DependencyInjection;
import com.example.djame.myfootballnews.R;
import com.example.djame.myfootballnews.presentation.standingDisplay.adapter.StandingAdapter;
import com.example.djame.myfootballnews.presentation.standingDisplay.adapter.StandingItemViewModel;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class StandingActivity extends Activity implements StandingContractView{

    private RecyclerView recyclerView;
    private StandingPresenter standingPresenter;
    private StandingAdapter standingAdapter;
    private String league_id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_standing);
        recyclerView=findViewById(R.id.standing_recyclerView);
        standingPresenter = new StandingPresenter(DependencyInjection.getStandingRepository());
        standingAdapter = new StandingAdapter();
        recyclerView.setAdapter(standingAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        league_id = getIntent().getStringExtra("LEAGUE_ID");
        standingPresenter.bindView(this);
        standingPresenter.getStandingByLeagueId(league_id);

    }

    @Override
    public void displayStanding(List<StandingItemViewModel> standingItemViewModels) {
        this.standingAdapter.bindViewModels(standingItemViewModels);
    }
}
