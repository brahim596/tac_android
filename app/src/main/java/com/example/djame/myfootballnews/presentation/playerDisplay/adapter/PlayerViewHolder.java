package com.example.djame.myfootballnews.presentation.playerDisplay.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.djame.myfootballnews.R;
import com.example.djame.myfootballnews.data.api.model.player.Player;
import com.example.djame.myfootballnews.presentation.leaguedisplay.adapter.LeagueItemViewModel;
import com.example.djame.myfootballnews.presentation.playerDisplay.PlayerContractView;
import com.like.LikeButton;

public class PlayerViewHolder extends RecyclerView.ViewHolder{

    private  Player player;

    private View view;
    private ImageView player_image;
    private TextView player_firstname;
    private TextView player_lastname;
    private TextView player_position;
    private TextView player_nationality;
    private TextView player_age;
    private TextView player_height;
    private TextView player_weight;
    private TextView player_number;
    private LikeButton likeButton;

    private PlayerContractView playerContractView;


    public PlayerViewHolder(@NonNull View itemView,PlayerContractView playerContractView) {
        super(itemView);
        view=itemView;
        player_age=view.findViewById(R.id.player_age);
        player_image=view.findViewById(R.id.player_image);
        player_firstname=view.findViewById(R.id.player_firstname);
        player_lastname=view.findViewById(R.id.player_lastname);
        player_height=view.findViewById(R.id.player_height);
        player_weight=view.findViewById(R.id.player_weight);
        player_number=view.findViewById(R.id.player_number);
        player_nationality=view.findViewById(R.id.player_nationality);
        player_position=view.findViewById(R.id.player_position);
        likeButton=view.findViewById(R.id.like_button);

        this.playerContractView = playerContractView;

    }

    public void bindViewModel(Player player){
        this.player = player;
        player_position.setText(player.getPosition());
        player_nationality.setText(player.getNationality());
        player_number.setText(player.getNumber()+"");
        player_weight.setText(player.getWeight());
        player_height.setText(player.getHeight());
        player_lastname.setText(player.getLastname());
        player_firstname.setText(player.getFirstname());
        player_age.setText(player.getAge());
        setUpImageByPosition();
        setupLikeButtonListenner();
    }

    private void setUpImageByPosition(){
        if(player.getPosition()!= null)
            switch (player.getPosition()){
                case "Goalkeeper": Glide.with(this.view).load("https://image.shutterstock.com/image-vector/soccer-goalkeeper-silhouette-vector-handball-260nw-1146699908.jpg").fitCenter().override(400,400).transition(DrawableTransitionOptions.withCrossFade(100)).into(player_image);break;
                case "Midfielder": Glide.with(this.view).load("data:image/png;base64,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").fitCenter().override(400,400).transition(DrawableTransitionOptions.withCrossFade(100)).into(player_image);break;
                case "Defender": Glide.with(this.view).load("https://cdn2.iconfinder.com/data/icons/rpg-fantasy-game-basic-ui/512/weapon_game_ui_fantasy_shield-512.png").fitCenter().override(400,400).transition(DrawableTransitionOptions.withCrossFade(100)).into(player_image);break;
                case "Attacker": Glide.with(this.view).load("https://i.ya-webdesign.com/images/battle-clipart-sword-fight-22.vnd").fitCenter().override(400,400).transition(DrawableTransitionOptions.withCrossFade(100)).into(player_image);break;
            }
    }

    private void setupLikeButtonListenner(){
        this.likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerContractView.addFavorite(new Player(player.getPlayer_id(),player.getPlayer_name(),player.getFirstname(),player.getLastname(),player.getNumber(),player.getPosition(),player.getAge(),player.getNationality(),player.getHeight(),player.getWeight()));
                likeButton.setLiked(true);
                Toast.makeText(view.getContext(),"Testing",Toast.LENGTH_LONG);
            }
        });
    }



}
