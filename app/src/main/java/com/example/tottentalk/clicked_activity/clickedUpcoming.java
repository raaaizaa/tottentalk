package com.example.tottentalk.clicked_activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tottentalk.R;
import com.example.tottentalk.activity.history;
import com.example.tottentalk.activity.main;
import com.example.tottentalk.javaclass.ticket;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class clickedUpcoming extends AppCompatActivity {

    private Button buyButton;
    private ImageButton backButton, historyButton;
    private ImageView teamOne, teamTwo;
    private TextView name, date;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clicked_upcoming_card);

        initialize();
    }

    public void initialize(){
        backButton = findViewById(R.id.backButton);
        setBackButton();

        historyButton = findViewById(R.id.historyButton);
        setCartButton();

        buyButton = findViewById(R.id.buyButton);
        setBuyButton();

        teamOne = findViewById(R.id.teamOne);
        teamTwo = findViewById(R.id.teamTwo);
        name = findViewById(R.id.gameName);
        date = findViewById(R.id.gameDate);
        setDefaultContent();
    }

    public void setBackButton(){
        backButton.setOnClickListener(e -> goToHomePage());
    }

    public void setCartButton(){
        historyButton.setOnClickListener(e -> goToHistoryPage());
    }

    public void setBuyButton() {
        buyButton.setOnClickListener(v -> {
            String msg = "Are you sure you want to buy this ticket?";

            new AlertDialog.Builder(this)
                    .setMessage(msg)
                    .setPositiveButton("Yes", (dialog, which) -> {
                        String game = "";
                        String selectedDate = date.getText().toString();

                        switch (selectedDate) {
                            case "April 28, 2023":
                                game = "Man United VS Tottenham";
                                break;
                            case "April 30, 2023":
                                game = "Liverpool VS Tottenham";
                                break;
                            case "May 6, 2023":
                                game = "Tottenham VS Crystal Palace";
                                break;
                        }

                        String currentDate = currentDate();
                        addTicket(game, selectedDate, currentDate);
                        Toast.makeText(clickedUpcoming.this, "Purchased!", Toast.LENGTH_LONG).show();
                    })
                    .setNegativeButton("No", null)
                    .show();
        });
    }

    public void addTicket(String name, String date, String currentDate){
        new ticket(name, date, currentDate);
    }


    public void setDefaultContent(){
        Intent intent = getIntent();

        int defaultImage1 = intent.getIntExtra("DefaultImageOne", 0);
        int defaultImage2 = intent.getIntExtra("DefaultImageTwo", 0);
        String defaultName = intent.getStringExtra("DefaultName");
        String defaultDate = intent.getStringExtra("DefaultDate");

        teamOne.setImageResource(defaultImage1);
        teamTwo.setImageResource(defaultImage2);
        name.setText(defaultName);
        date.setText(defaultDate);
    }

    public void goToHomePage(){
        Intent intent = new Intent(this, main.class);
        startActivity(intent);
    }

    public void goToHistoryPage(){
        Intent intent = new Intent(this, history.class);
        startActivity(intent);
    }

    public String currentDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        return dtf.format(now);
    }
}
