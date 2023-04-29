package com.example.tottentalk;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class clickedUpcoming extends AppCompatActivity {

    private Button buyButton;
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

        buyButton = findViewById(R.id.buyButton);
        setBuyButton();

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

    public void setBuyButton() {
        buyButton.setOnClickListener(v -> {
            String msg = "Are you sure you want to buy this ticket?";
            new AlertDialog.Builder(this)
                    .setMessage(msg)
                    .setPositiveButton("Yes", (dialog, which) -> {
                        String game = "";
                        String selectedDate = date.getText().toString();

                        if(selectedDate.equals("April 28, 2023")){
                            game = "Man United VS Tottenham";
                        }else if(selectedDate.equals("April 30, 2023")) {
                            game = "Liverpool VS Tottenham";
                        }else if(selectedDate.equals("May 6, 2023")) {
                            game = "Tottenham VS Crystal Palace";
                        }
                        addTicket(game, selectedDate);
                        Toast.makeText(clickedUpcoming.this, "Success adding " + game + "!", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("No", null)
                    .show();
        });
    }

    public void addTicket(String name, String date){
        new ticket(name, date);
        Log.i("tes", ticket.getTicketList().toString());
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
        Intent intent = new Intent(this, cart.class);
        startActivity(intent);
    }
}
