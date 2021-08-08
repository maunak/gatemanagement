package com.example.gate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {
    public CardView visitorsentry, courierentry, fooddeliveryentry, workersentry;
    public Button entrylist,logout;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        visitorsentry = (CardView) findViewById(R.id.visitors);
        courierentry = (CardView) findViewById(R.id.courier);
        fooddeliveryentry = (CardView) findViewById(R.id.fooddelivery);
        workersentry = (CardView) findViewById(R.id.workers);
        entrylist = (Button) findViewById(R.id.button2) ;
        logout = (Button) findViewById(R.id.buttonlogout) ;

        visitorsentry.setOnClickListener(this);
        courierentry.setOnClickListener(this);
        fooddeliveryentry.setOnClickListener(this);
        workersentry.setOnClickListener(this);
        entrylist.setOnClickListener(this);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, MainActivity.class);
                startActivity(intent);
                finish()  ;     }
        });
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.visitors:
                i = new Intent(this, visitors.class);
                startActivity(i);
                break;
            case R.id.courier:
                i = new Intent(this, courier.class);
                startActivity(i);
                break;
            case R.id.fooddelivery:
                i = new Intent(this, fooddelivery.class);
                startActivity(i);
                break;
            case R.id.workers:
                i = new Intent(this, workers.class);
                startActivity(i);
                break;
            case R.id.button2:
                i = new Intent(this, entrylist.class);
                startActivity(i);
                break;
        }
    }
}