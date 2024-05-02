package com.example.studyplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class welcome extends AppCompatActivity implements View.OnClickListener {

    public CardView bridge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);

        bridge = (CardView) findViewById(R.id.lsbridge);
        bridge.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        Intent intent;

        if(v.getId() == R.id.lsbridge){
            intent = new Intent(this, login.class);
            startActivity(intent);
        }

    }
}