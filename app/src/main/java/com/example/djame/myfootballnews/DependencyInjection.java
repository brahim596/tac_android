package com.example.djame.myfootballnews;

import com.example.djame.myfootballnews.data.api.model.LeagueDisplayService;
import com.example.djame.myfootballnews.data.api.model.PlayerDisplayService;
import com.example.djame.myfootballnews.data.api.model.StandingDisplayService;
import com.example.djame.myfootballnews.data.repository.league.LeagueDataRepository;
import com.example.djame.myfootballnews.data.repository.league.LeagueRepository;
import com.example.djame.myfootballnews.data.repository.league.remote.LeagueRemoteDataSource;
import com.example.djame.myfootballnews.data.repository.player.PlayerDataRepository;
import com.example.djame.myfootballnews.data.repository.player.PlayerRepository;
import com.example.djame.myfootballnews.data.repository.player.remote.PlayerRemoteDataSource;
import com.example.djame.myfootballnews.data.repository.standing.StandingDataRepository;
import com.example.djame.myfootballnews.data.repository.standing.StandingRepository;
import com.example.djame.myfootballnews.data.repository.standing.remote.StandingRemoteDataSource;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DependencyInjection {

    private static LeagueRepository leagueRepository;
    private static LeagueDisplayService leagueDisplayService;

    private static StandingRepository standingRepository;
    private static StandingDisplayService standingDisplayService;

    private static PlayerRepository playerRepository;
    private static PlayerDisplayService playerDisplayService;

    private static Retrofit retrofit;
    private static Gson gson;

    public static String API_KEY="0b7833025emsh727af8e17b15433p1773dbjsndcee749125ca";

    public static LeagueRepository getLeagueRepository(){
        if(leagueRepository==null)
           leagueRepository = new LeagueDataRepository(new LeagueRemoteDataSource(getLeagueDisplayService()));

        return leagueRepository;
    }

    public static LeagueDisplayService getLeagueDisplayService(){
        if(leagueDisplayService==null)
                leagueDisplayService = getRetrofit().create(LeagueDisplayService.class);

        return leagueDisplayService;
    }

    public static StandingRepository getStandingRepository(){
        if(standingRepository==null)
            standingRepository = new StandingDataRepository(new StandingRemoteDataSource(getStandingDisplayService()));

        return standingRepository;
    }

    public static StandingDisplayService getStandingDisplayService(){
        if(standingDisplayService==null)
            standingDisplayService = getRetrofit().create(StandingDisplayService.class);

        return standingDisplayService;
    }

    public static PlayerRepository getPlayerRepository(){
        if(playerRepository==null)
            playerRepository = new PlayerDataRepository(new PlayerRemoteDataSource(getPlayerDisplayService()));

        return playerRepository;
    }

    public static PlayerDisplayService getPlayerDisplayService(){
        if(playerDisplayService==null)
            playerDisplayService = getRetrofit().create(PlayerDisplayService.class);

        return playerDisplayService;
    }

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                  //  .addNetworkInterceptor(new StethoInterceptor())
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api-football-v1.p.rapidapi.com/v2/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(getGson()))
                    .build();
        }
        return retrofit;
    }

    public static Gson getGson() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }
}
