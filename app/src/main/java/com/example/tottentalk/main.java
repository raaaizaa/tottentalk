package com.example.tottentalk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class main extends AppCompatActivity {

    private ArrayList<news> newsList = new ArrayList<>();
    private ArrayList<upcoming> upcomingList = new ArrayList<>();
    private RecyclerView newsRV, upcomingRV;
    private ImageButton backButton, cartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    public void initialize(){
        backButton = findViewById(R.id.backButton);
        setBackButton();

        cartButton = findViewById(R.id.cartButton);
        setCartButton();

        newsRV = findViewById(R.id.news_recyclerview);
        newsRV.setHasFixedSize(true);
        newsList.addAll(getNewsList());

        upcomingRV = findViewById(R.id.upcoming_recyclerview);
        upcomingRV.setHasFixedSize(true);
        upcomingList.addAll(getUpcomingList());
        showRecyclerList();
    }

    public void setBackButton(){
        backButton.setOnClickListener(e -> {
            goToLoginPage();
        });
    }

    public void setCartButton(){
        cartButton.setOnClickListener(e -> {
            goToCartPage();
        });
    }

    public void goToLoginPage(){
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }

    public void goToCartPage(){
        // ehe
    }

    public ArrayList<news> getNewsList(){
        String[] headline = getResources().getStringArray(R.array.news_headline);
        String[] date = getResources().getStringArray(R.array.news_date);
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
        TypedArray teamoneImage = getResources().obtainTypedArray(R.array.club_logo);
        TypedArray teamtwoImage = getResources().obtainTypedArray(R.array.club_logo);
        String[] gamename = getResources().getStringArray(R.array.upcoming_plays);
        String[] gamedate = getResources().getStringArray(R.array.upcoming_date);

        ArrayList<upcoming> listUpcoming = new ArrayList<>();

        for(int i = 0; i < gamename.length; i++){
            int tottenham = 0, manutd = 1, liv = 2, crystal = 3;
            upcoming upcoming = new upcoming();
            upcoming.setGamename(gamename[i]);
            upcoming.setGamedate(gamedate[i]);

            if(i == 0){
                upcoming.setTeamone(teamoneImage.getResourceId(manutd, -1));
                upcoming.setTeamtwo(teamtwoImage.getResourceId(tottenham, -1));
            }else if(i == 1){
                upcoming.setTeamone(teamoneImage.getResourceId(liv, -1));
                upcoming.setTeamtwo(teamtwoImage.getResourceId(tottenham, -1));
            }else if(i == 2){
                upcoming.setTeamone(teamoneImage.getResourceId(tottenham, -1));
                upcoming.setTeamtwo(teamtwoImage.getResourceId(crystal, -1));
            }

            listUpcoming.add(upcoming);
        }

        return listUpcoming;
    }

    private void showRecyclerList(){
        newsRV.setLayoutManager(new LinearLayoutManager((this)));
        newsAdapter newsAdapter = new newsAdapter(newsList, this);
        newsRV.setAdapter(newsAdapter);

        newsAdapter.setOnItemClickCallback(data -> showNewsSelected(data));

        upcomingRV.setLayoutManager(new LinearLayoutManager((this)));
        upcomingAdapter upcomingAdapter = new upcomingAdapter(upcomingList, this);
        upcomingRV.setAdapter(upcomingAdapter);

        upcomingAdapter.setOnItemClickCallback(data -> showUpcomingSelected(data));
    }

    private void showNewsSelected(news news){
        Toast.makeText(this, "Yeess berhasil milih" + news.getHeadline(), Toast.LENGTH_SHORT).show();
    }

    private void showUpcomingSelected(upcoming upcoming){
        Toast.makeText(this, "Yeess berhasil milih" + upcoming.getGamename(), Toast.LENGTH_SHORT).show();
    }

}