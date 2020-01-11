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

    public LeaguePresenter(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
        this.compositeDisposable = new CompositeDisposable();
        leagueItemViewModels= new ArrayList<>();
    }


    public void getLeagues(){
        compositeDisposable.add(this.leagueRepository.getLeagueById("2",DependencyInjection.API_KEY)
        .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<LeagueResponse>() {

                    @Override
                    public void onSuccess(LeagueResponse leagueResponse) {
                        leagueItemViewModels.add(mapResponseToViewModel(leagueResponse));
                        leagueContractView.displayLeagues(leagueItemViewModels);

                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("error");
                    }
                }));

    }

    public void bindView(LeagueContractView leagueContractView){
        this.leagueContractView=leagueContractView;
    }

    private LeagueItemViewModel mapResponseToViewModel(LeagueResponse leagueResponse){
        if(leagueResponse.getLeagueBody().getResults()==1){
            League league = leagueResponse.getLeagueBody().getLeagues().get(0);
            return new LeagueItemViewModel(league.getLeague_id(),league.getName(),league.getCountry(),league.getLogo());
        }
        return null;
    }
}
