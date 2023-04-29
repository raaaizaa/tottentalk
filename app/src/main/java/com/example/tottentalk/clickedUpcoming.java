package com.example.tottentalk;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class clickedUpcoming extends AppCompatActivity {

    private ImageButton backButton, cartButton;
    private ImageView teamone, teamtwo;
    private TextView name, date;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clicked_upcoming_card);

        initialize();
    }

    public void initialize(){
        backButton = findViewById(R.id.backButton);
        setBackButton();

        cartButton = findViewById(R.id.cartButton);
        setCartButton();

        teamone = findViewById(R.id.teamone);
        teamtwo = findViewById(R.id.teamtwo);
        name = findViewById(R.id.gamename);
        date = findViewById(R.id.gamedate);
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

        Integer defaultImage1 = intent.getIntExtra("DefaultImageOne", 0);
        Integer defaultImage2 = intent.getIntExtra("DefaultImageTwo", 0);
        String defaultName = intent.getStringExtra("DefaultName");
        String defaultDate = intent.getStringExtra("DefaultDate");

        teamone.setImageResource(defaultImage1);
        teamtwo.setImageResource(defaultImage2);
        name.setText(defaultName);
        date.setText(defaultDate);
    }

    public void goToHomePage(){
        Intent intent = new Intent(this, main.class);
        startActivity(intent);
    }

    public void goToCartPage(){
        // ehe
    }
}
