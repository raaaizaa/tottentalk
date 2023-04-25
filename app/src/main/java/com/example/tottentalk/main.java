package com.example.tottentalk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class main extends AppCompatActivity {

    private ImageButton backButton, cartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void initialize(){
        backButton = findViewById(R.id.backButton);
        setBackButton();

        cartButton = findViewById(R.id.cartButton);
        setCartButton();
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

    }
}