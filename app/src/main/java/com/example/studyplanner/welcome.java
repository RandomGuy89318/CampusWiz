package com.example.studyplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class welcome extends AppCompatActivity  {

    public CardView bridge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);

        CardView btn_welcome=findViewById(R.id.lsbridge);


        btn_welcome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openactivity_login();
            }
        });


    }public  void  openactivity_login(){
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }

}