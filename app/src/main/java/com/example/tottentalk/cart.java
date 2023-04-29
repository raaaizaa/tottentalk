package com.example.tottentalk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class cart extends AppCompatActivity {

    private ImageButton backButton, cartButton;
    private ListView purchaseList;
    private ticket ticket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        initialize();
    }

    public void initialize(){
        backButton = findViewById(R.id.backButton);
        setBackButton();

        cartButton = findViewById(R.id.cartButton);
        setCartButton();

        purchaseList = findViewById(R.id.purchaseList);
        showPurchaseList();
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

    public void showPurchaseList(){

        List<ticket> ticketList = ticket.getTicketList();
        Log.i("tes", ticketList.toString());

        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.purchase_listview, R.id.orderedList, ticketList);
        Log.i("tes", "tes");
        purchaseList.setAdapter(adapter);
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