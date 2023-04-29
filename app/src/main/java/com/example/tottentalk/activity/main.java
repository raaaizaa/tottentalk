package com.example.tottentalk.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ImageButton;

import com.example.tottentalk.R;
import com.example.tottentalk.adapter.newsAdapter;
import com.example.tottentalk.adapter.upcomingAdapter;

import java.util.ArrayList;

public class main extends AppCompatActivity {

    private final ArrayList<news> newsList = new ArrayList<>();
    private final ArrayList<upcoming> upcomingList = new ArrayList<>();
    private RecyclerView newsRV, upcomingRV;
    private ImageButton backButton, historyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    public void initialize(){
        backButton = findViewById(R.id.backButton);
        setBackButton();

        historyButton = findViewById(R.id.historyButton);
        setHistoryButton();

        newsRV = findViewById(R.id.news_recyclerview);
        newsRV.setHasFixedSize(true);
        newsList.addAll(getNewsList());
        showNewsList();

        upcomingRV = findViewById(R.id.upcoming_recyclerview);
        upcomingRV.setHasFixedSize(true);
        upcomingList.addAll(getUpcomingList());
        showUpcomingList();
    }

    public void setBackButton(){
        backButton.setOnClickListener(e -> goToLoginPage());
    }

    public void setHistoryButton(){
        historyButton.setOnClickListener(e -> goToHistoryPage());
    }

    public void goToLoginPage(){
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }

    public void goToHistoryPage(){
        Intent intent = new Intent(this, history.class);
        startActivity(intent);
    }

    public ArrayList<news> getNewsList(){
        String[] headline = getResources().getStringArray(R.array.news_headline);
        String[] date = getResources().getStringArray(R.array.news_date);

        @SuppressLint("Recycle")
        TypedArray image = getResources().obtainTypedArray(R.array.news_picture);

        ArrayList<news> listNews = new ArrayList<>();

        for(int i = 0; i < headline.length; i++){
            news news = new news();
            news.setHeadline(headline[i]);
            news.setDate(date[i]);
            news.setPicture(image.getResourceId(i, -1));

            listNews.add(news);
        }

        return listNews;
    }

    public ArrayList<upcoming> getUpcomingList(){
        @SuppressLint("Recycle")
        TypedArray teamOneImage = getResources().obtainTypedArray(R.array.club_logo);
        @SuppressLint("Recycle")
        TypedArray teamTwoImage = getResources().obtainTypedArray(R.array.club_logo);

        String[] gameName = getResources().getStringArray(R.array.upcoming_plays);
        String[] gameDate = getResources().getStringArray(R.array.upcoming_date);

        ArrayList<upcoming> listUpcoming = new ArrayList<>();

        for(int i = 0; i < gameName.length; i++){
            int tottenham = 0, man_utd = 1, liv = 2, crystal = 3;
            upcoming upcoming = new upcoming();
            upcoming.setGameName(gameName[i]);
            upcoming.setGameDate(gameDate[i]);

            if(i == 0){
                upcoming.setTeamOne(teamOneImage.getResourceId(man_utd, -1));
                upcoming.setTeamTwo(teamTwoImage.getResourceId(tottenham, -1));
            }else if(i == 1){
                upcoming.setTeamOne(teamOneImage.getResourceId(liv, -1));
                upcoming.setTeamTwo(teamTwoImage.getResourceId(tottenham, -1));
            }else if(i == 2){
                upcoming.setTeamOne(teamOneImage.getResourceId(tottenham, -1));
                upcoming.setTeamTwo(teamTwoImage.getResourceId(crystal, -1));
            }

            listUpcoming.add(upcoming);
        }

        return listUpcoming;
    }

    private void showUpcomingList(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(main.this, LinearLayoutManager.HORIZONTAL, false);

        upcomingAdapter upcomingAdapter = new upcomingAdapter(upcomingList, this);
        upcomingRV.setLayoutManager(layoutManager);
        upcomingRV.setAdapter(upcomingAdapter);
    }

    private void showNewsList(){
        newsRV.setLayoutManager(new LinearLayoutManager((this)));
        newsAdapter newsAdapter = new newsAdapter(newsList, this);
        newsRV.setAdapter(newsAdapter);

    }



}