package com.example.djame.myfootballnews.presentation.leaguedisplay;

import android.widget.Toast;

import com.example.djame.myfootballnews.DependencyInjection;
import com.example.djame.myfootballnews.data.api.model.league.League;
import com.example.djame.myfootballnews.data.api.model.league.LeagueResponse;
import com.example.djame.myfootballnews.data.repository.league.LeagueRepository;
import com.example.djame.myfootballnews.presentation.leaguedisplay.adapter.LeagueItemViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class LeaguePresenter {

    private LeagueRepository leagueRepository;
    private LeagueContractView leagueContractView;
    private CompositeDisposable compositeDisposable;

    private List<LeagueItemViewModel> leagueItemViewModels;

    private List<String> countryLeaguesToShow;

    public LeaguePresenter(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
        this.compositeDisposable = new CompositeDisposable();
        leagueItemViewModels= new ArrayList<>();
        this.countryLeaguesToShow = new ArrayList<>();
        this.countryLeaguesToShow.add("england");
        this.countryLeaguesToShow.add("france");
        //this.countryLeaguesToShow.add("italy");
        //this.countryLeaguesToShow.add("spain");
    }


    public void getLeagues(){

        for(String country: this.countryLeaguesToShow)
            compositeDisposable.add(this.leagueRepository.getCurrentSeasonsFromLeaguesByCountry(country,DependencyInjection.API_KEY)
            .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableSingleObserver<LeagueResponse>() {

                        @Override
                        public void onSuccess(LeagueResponse leagueResponse) {
                            leagueItemViewModels.addAll(mapResponseToViewModel(leagueResponse));
                            leagueContractView.displayLeagues(leagueItemViewModels);

                        }

                        @Override
                        public void onError(Throwable e) {
                            System.out.println("error");
                        }
                    }));


        /*leagueItemViewModels.add(new LeagueItemViewModel(2,"Premier League","England","https://media.api-football.com/leagues/2.png"));
        leagueItemViewModels.add(new LeagueItemViewModel(2,"Premier League","England","https://media.api-football.com/leagues/2.png"));
        leagueItemViewModels.add(new LeagueItemViewModel(2,"Premier League","England","https://media.api-football.com/leagues/2.png"));
        leagueItemViewModels.add(new LeagueItemViewModel(2,"Premier League","England","https://media.api-football.com/leagues/2.png"));
        leagueItemViewModels.add(new LeagueItemViewModel(2,"Premier League","England","https://media.api-football.com/leagues/2.png"));
        leagueItemViewModels.add(new LeagueItemViewModel(2,"Premier League","England","https://media.api-football.com/leagues/2.png"));
        leagueItemViewModels.add(new LeagueItemViewModel(2,"Premier League","England","https://media.api-football.com/leagues/2.png"));
        leagueItemViewModels.add(new LeagueItemViewModel(2,"Premier League","England","https://media.api-football.com/leagues/2.png"));
        leagueItemViewModels.add(new LeagueItemViewModel(2,"Premier League","England","https://media.api-football.com/leagues/2.png"));
        leagueItemViewModels.add(new LeagueItemViewModel(2,"Premier League","England","https://media.api-football.com/leagues/2.png"));
        leagueContractView.displayLeagues(leagueItemViewModels);*/

    }

    public void bindView(LeagueContractView leagueContractView){
        this.leagueContractView=leagueContractView;
    }

    private List<LeagueItemViewModel> mapResponseToViewModel(LeagueResponse leagueResponse){
        List<LeagueItemViewModel> itemViewModels = new ArrayList<>();
        if(leagueResponse.getLeagueBody().getResults()>0){
            for(League league: leagueResponse.getLeagueBody().getLeagues())
                itemViewModels.add(new LeagueItemViewModel(league.getLeague_id(),league.getName(),league.getCountry(),league.getLogo()));
        }
        return itemViewModels;
    }
}
