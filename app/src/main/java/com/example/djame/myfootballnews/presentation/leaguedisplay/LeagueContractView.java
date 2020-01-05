package com.example.djame.myfootballnews.presentation.leaguedisplay;

import com.example.djame.myfootballnews.presentation.leaguedisplay.adapter.LeagueItemViewModel;

import java.util.List;

public interface LeagueContractView {

    public void displayLeagues(List<LeagueItemViewModel> leagueItemViewModels);
}
