package com.example.tottentalk.clicked_activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tottentalk.R;
import com.example.tottentalk.activity.history;
import com.example.tottentalk.activity.main;

public class clickedNews extends AppCompatActivity {

    private ImageButton backButton, historyButton;
    private ImageView image;
    private TextView headline, date, description;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clicked_news_card);

        initialize();
    }

    public void initialize(){
        backButton = findViewById(R.id.backButton);
        setBackButton();

        historyButton = findViewById(R.id.historyButton);
        setHistoryButton();

        image = findViewById(R.id.news_image);
        headline = findViewById(R.id.news_headline);
        date = findViewById(R.id.news_date);
        description = findViewById(R.id.news_description);
        setDefaultContent();
    }

    public void setBackButton(){
        backButton.setOnClickListener(e -> goToHomePage());
    }

    public void setHistoryButton(){
        historyButton.setOnClickListener(e -> goToHistoryPage());
    }

    public void setDefaultContent(){
        Intent intent = getIntent();

        int defaultImage = intent.getIntExtra("DefaultImage", 0);
        String defaultHeadline = intent.getStringExtra("DefaultHeadline");
        String defaultDate = intent.getStringExtra("DefaultDate");
        String defaultDescription = intent.getStringExtra("DefaultDescription");

        image.setImageResource(defaultImage);
        headline.setText(defaultHeadline);
        date.setText(defaultDate);
        description.setText(defaultDescription);
    }

    public void goToHomePage(){
        Intent intent = new Intent(this, main.class);
        startActivity(intent);
    }

    public void goToHistoryPage(){
        Intent intent = new Intent(this, history.class);
        startActivity(intent);
    }
}
