package com.example.djame.myfootballnews.presentation.standingDisplay;

import com.example.djame.myfootballnews.DependencyInjection;
import com.example.djame.myfootballnews.data.api.model.standings.Standing;
import com.example.djame.myfootballnews.data.api.model.standings.StandingResponse;
import com.example.djame.myfootballnews.data.repository.standing.StandingRepository;
import com.example.djame.myfootballnews.presentation.standingDisplay.adapter.StandingItemViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class StandingPresenter {

    private StandingRepository standingRepository;
    private StandingContractView standingContractView;
    private CompositeDisposable compositeDisposable;

    private List<StandingItemViewModel> standingItemViewModels;

    public StandingPresenter(StandingRepository standingRepository) {
        this.standingRepository = standingRepository;
        this.compositeDisposable= new CompositeDisposable();
        standingItemViewModels = new ArrayList<>();
    }

    public void bindView(StandingContractView standingContractView){
        this.standingContractView = standingContractView;
    }

    public void getStandingByLeagueId(String leagueId){

        this.compositeDisposable.add(this.standingRepository.getStandingByLeagueId(leagueId,DependencyInjection.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<StandingResponse>() {

                    @Override
                    public void onSuccess(StandingResponse standingResponse) {
                        standingItemViewModels.addAll(mapResponseToViewModel(standingResponse));
                        standingContractView.displayStanding(standingItemViewModels);

                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("error");
                    }
                }));
    }

    public void bindViewModels( List<StandingItemViewModel> standingItemViewModels){
        this.standingItemViewModels = standingItemViewModels;
    }

    private List<StandingItemViewModel> mapResponseToViewModel(StandingResponse standingResponse){

        List<StandingItemViewModel> standingItemViewModels = new ArrayList<>();

        List<Standing> standings = standingResponse.getApi().getStandings().get(0);
        for(Standing standing: standings)
             standingItemViewModels.add( new StandingItemViewModel( standing.getRank(),
                                                                    standing.getTeam_id(),
                                                                    standing.getTeamName(),
                                                                    standing.getLogo(),
                                                                    standing.getGroup(),
                                                                    standing.getForme(),
                                                                    standing.getAll(),
                                                                    standing.getHome(),
                                                                    standing.getAway(),
                                                                    standing.getGoalsDiff(),
                                                                    standing.getRank(),
                                                                    standing.getLastUpdate(),
                                                                    standing.getNbGamesPlayed())
                                                                    );

        return standingItemViewModels;

    }
}
