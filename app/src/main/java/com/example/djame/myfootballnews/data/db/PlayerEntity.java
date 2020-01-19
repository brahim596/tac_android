package com.example.djame.myfootballnews.data.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PlayerEntity {

    @PrimaryKey
    int player_id;
    String player_name;
    String firstname;
    String lastname;
    int number;
    String position;
    String age;
    String nationality;
    String height;
    String weight;

    public PlayerEntity(int player_id, String player_name, String firstname, String lastname, int number, String position, String age, String nationality, String height, String weight) {
        this.player_id = player_id;
        this.player_name = player_name;
        this.firstname = firstname;
        this.lastname = lastname;
        this.number = number;
        this.position = position;
        this.age = age;
        this.nationality = nationality;
        this.height = height;
        this.weight = weight;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
