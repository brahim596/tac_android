package com.example.djame.myfootballnews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.res.Configuration;
import android.os.Bundle;

import com.example.djame.myfootballnews.data.api.model.league.League;
import com.example.djame.myfootballnews.data.api.model.player.Player;
import com.example.djame.myfootballnews.presentation.leaguedisplay.LeagueContractView;
import com.example.djame.myfootballnews.presentation.leaguedisplay.LeaguePresenter;
import com.example.djame.myfootballnews.presentation.leaguedisplay.adapter.LeagueAdapter;
import com.example.djame.myfootballnews.presentation.leaguedisplay.adapter.LeagueItemViewModel;
import com.example.djame.myfootballnews.presentation.leaguedisplay.fragment.LeaguesFragment;
import com.example.djame.myfootballnews.presentation.playerDisplay.fragment.PlayerFragment;

import java.util.List;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity  {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpFragments();
    }

    private void setUpFragments(){
        viewPager=findViewById(R.id.viewPage);
        final LeaguesFragment leaguesFragment = LeaguesFragment.newInstance();
        final PlayerFragment playerFragment= PlayerFragment.newInstance();

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return position==0 ? leaguesFragment : playerFragment;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                if (position == 0) {
                    return "Leagues";
                }
                return "Players";
            }

            @Override
            public int getCount() {
                return 2;
            }
        });
    }

}
