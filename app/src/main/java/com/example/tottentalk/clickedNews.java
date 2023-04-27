package com.example.tottentalk;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class clickedNews extends AppCompatActivity {

    private ImageButton backButton, cartButton;
    private ImageView picture;
    private TextView headline, date, description;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clicked_news_card);

        initialize();
    }

    public void initialize(){
        backButton = findViewById(R.id.backButton);
        setBackButton();

        cartButton = findViewById(R.id.cartButton);
        setCartButton();

        picture = findViewById(R.id.news_image);
        headline = findViewById(R.id.news_headline);
        date = findViewById(R.id.news_date);
        description = findViewById(R.id.news_description);
        setDetails();
    }

    public void setBackButton(){
        backButton.setOnClickListener(e -> {
            goToHomePage();
        });
    }

    public void setCartButton(){
        cartButton.setOnClickListener(e -> {
            goToCartPage();
        });
    }

    public void setDetails(){
        Intent intent = getIntent();

        Integer defaultImage = intent.getIntExtra("DefaultImage", 0);
        String defaultHeadline = intent.getStringExtra("DefaultHeadline");
        String defaultDate = intent.getStringExtra("DefaultDate");
        String defaultDescription = intent.getStringExtra("DefaultDescription");

        picture.setImageResource(defaultImage);
        headline.setText(defaultHeadline);
        date.setText(defaultDate);
        description.setText(defaultDescription);
    }

    public void goToHomePage(){
        Intent intent = new Intent(this, main.class);
        startActivity(intent);
    }

    public void goToCartPage(){
        // ehe
    }
}
