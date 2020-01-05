package com.example.djame.myfootballnews.presentation.leaguedisplay;

import com.example.djame.myfootballnews.data.repository.league.LeagueRepository;

import io.reactivex.disposables.CompositeDisposable;

public class LeaguePresenter {

    private LeagueRepository leagueRepository;
    private LeagueContractView leagueContractView;
    private CompositeDisposable compositeDisposable;

    public LeaguePresenter(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
        this.compositeDisposable = new CompositeDisposable();
    }


    public void getLeagues(){

    }

    public void bindView(LeagueContractView leagueContractView){
        this.leagueContractView=leagueContractView;
    }
}
