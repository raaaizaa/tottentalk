package com.example.tottentalk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    private EditText usernameField, passwordField;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialize();
    }

    public void initialize(){
        usernameField = findViewById(R.id.usernameField);
        passwordField = findViewById(R.id.passwordField);

        loginButton = findViewById(R.id.loginButton);
        setLoginButton();
    }

    public void setLoginButton(){
        loginButton.setOnClickListener(e -> {
            String username = usernameField.getText().toString();
            String password = passwordField.getText().toString();

            if(username.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "All fields must be filled!", Toast.LENGTH_SHORT).show();
            }else if(username.equals("dummy") && password.equals("dummy123")){
                Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show();
                goToHomepage();
            }else{
                Toast.makeText(this, "Invalid username or password!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void goToHomepage(){
        Intent intent = new Intent(this, main.class);
        startActivity(intent);
    }
}