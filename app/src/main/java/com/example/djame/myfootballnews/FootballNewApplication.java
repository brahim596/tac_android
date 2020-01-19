package com.example.djame.myfootballnews;

import android.app.Application;

public class FootballNewApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DependencyInjection.setContext(this);
    }
}
