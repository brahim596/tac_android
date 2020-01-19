package com.example.djame.myfootballnews.presentation.playerDisplay;

import com.example.djame.myfootballnews.DependencyInjection;
import com.example.djame.myfootballnews.data.api.model.league.LeagueResponse;
import com.example.djame.myfootballnews.data.api.model.player.Player;
import com.example.djame.myfootballnews.data.api.model.player.PlayerResponse;
import com.example.djame.myfootballnews.data.db.PlayerEntity;
import com.example.djame.myfootballnews.data.repository.player.PlayerDataRepository;
import com.example.djame.myfootballnews.data.repository.player.PlayerRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

public class PlayerPresenter {

    private PlayerRepository playerRepository;
    private PlayerContractView playerContractView;
    private CompositeDisposable compositeDisposable;

    public PlayerPresenter(PlayerRepository playerRepository, PlayerContractView playerContractView) {
        this.playerRepository = playerRepository;
        this.playerContractView = playerContractView;
        this.compositeDisposable = new CompositeDisposable();
    }

    public void searchPlayer(String name){
        this.compositeDisposable.add(this.playerRepository.searchPlayerByName(name, DependencyInjection.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<PlayerResponse>() {

                    @Override
                    public void onSuccess(PlayerResponse playerResponse) {
                        playerContractView.displayPlayers( filterPlayerByFame(playerResponse.getApi().getPlayers()));
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("error");
                    }
                }));
    }

    public void addToFavorite(Player player){
        playerRepository.insertPlayerLocalDatabase(player);
    }

    public void getFavoritesPlayer(){
        this.compositeDisposable.add(this.playerRepository.loadFavoritedPlayer()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<List<PlayerEntity>>() {

                    @Override
                    public void onNext(List<PlayerEntity> playerEntityList) {
                        playerContractView.displayFavoritesPlayers(mapListPlayerEntryToPlayer(playerEntityList));
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        //Do Nothing
                    }
                }));
    }

    public void bindView(PlayerContractView playerContractView){
        this.playerContractView=playerContractView;
    }

    /**
     * Filtre les joueurs en fonction de la popularité
     * car l'API renseigne beaucoup trop de joueur non connu du
     * grand publique.
     * On filtre donc en vérifiant si le poid est renseigné, seul méthode trouvé pour le moment
     * @param players
     * @return
     */
    private List<Player> filterPlayerByFame(List<Player> players){

        List<Player> filteredPlayer = new ArrayList<>();
        for(Player player:players)
            if(player.getWeight()!=null && !player.getWeight().equals(""))
                filteredPlayer.add(player);
         return filteredPlayer;
    }

    private List<Player> mapListPlayerEntryToPlayer(List<PlayerEntity> playerEntityList){
        List<Player> players = new ArrayList<>();
        for(PlayerEntity playerEntity: playerEntityList)
            players.add(PlayerDataRepository.mapPlayerEntityToPlayer(playerEntity));

        return players;
    }


}
