package com.example.tottentalk.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.tottentalk.R;
import com.example.tottentalk.javaclass.ticket;

import java.util.List;

public class history extends AppCompatActivity {

    private ImageButton backButton, historyButton;
    private ListView purchaseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        initialize();
    }

    public void initialize(){
        backButton = findViewById(R.id.backButton);
        setBackButton();

        historyButton = findViewById(R.id.historyButton);
        setHistoryButton();

        purchaseList = findViewById(R.id.purchaseList);
        showPurchaseList();
    }

    public void setBackButton(){
        backButton.setOnClickListener(e -> goToHomePage());
    }

    public void setHistoryButton(){
        historyButton.setOnClickListener(e -> goToCartPage());
    }

    public void showPurchaseList(){
        List<ticket> ticketList = ticket.getTicketList();

        ArrayAdapter<ticket> adapter = new ArrayAdapter<>(this, R.layout.purchase_listview, R.id.orderedList, ticketList);
        purchaseList.setAdapter(adapter);
    }

    public void goToHomePage(){
        Intent intent = new Intent(this, main.class);
        startActivity(intent);
    }

    public void goToCartPage(){
        Intent intent = new Intent(this, history.class);
        startActivity(intent);
    }
}