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
    private RecyclerView newsRV;
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

    private void showRecyclerList(){
        newsRV.setLayoutManager(new LinearLayoutManager((this)));
        newsAdapter newsAdapter = new newsAdapter(newsList, this);
        newsRV.setAdapter(newsAdapter);

        newsAdapter.setOnItemClickCallback(data -> showSelected(data));
    }

    private void showSelected(news news){
        Toast.makeText(this, "Yeess berhasil milih" + news.getHeadline(), Toast.LENGTH_SHORT).show();
    }

}