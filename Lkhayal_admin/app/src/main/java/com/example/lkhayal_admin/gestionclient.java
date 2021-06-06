package com.example.lkhayal_admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class gestionclient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestionclient);





        CardView detail = findViewById(R.id.detailclient);
        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), detailclient.class);
                startActivityForResult(myIntent, 0);
                finish();
            }
        });


        CardView modifierclient = findViewById(R.id.modifier);
        modifierclient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), modifierclient.class);
                startActivityForResult(myIntent, 0);
                finish();
            }
        });

        CardView supprimerclient = findViewById(R.id.supprimer);
        supprimerclient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), supprimerclient.class);
                startActivityForResult(myIntent, 0);
                finish();
            }
        });

    }

        }

