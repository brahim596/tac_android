package com.example.djame.myfootballnews.presentation.leaguedisplay.adapter;

public class LeagueItemViewModel {

    private int id;
    private String name;
    private String country;
    private String urlLogo;

    public int getId() {
        return id;
    }

    public LeagueItemViewModel(int id, String name, String country, String urlLogo) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.urlLogo = urlLogo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }
}
