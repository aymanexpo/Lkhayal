package com.example.lkhayal_admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class detailpresent extends AppCompatActivity {
    int position;
    EditText title, startDate,  userFk, isdone,id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailpresent);
        ImageView retour = findViewById(R.id.retourimg);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), presence.class);
                startActivityForResult(myIntent, 0);
                finish();
            }
        });
        ImageView Home = findViewById(R.id.Home);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), admindashboard.class);
                startActivityForResult(myIntent, 0);
                finish();
            }
        });

        ImageView power = findViewById(R.id.Power);
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), activity_login.class);
                startActivityForResult(myIntent, 0);
                finish();
            }
        });

        id = findViewById(R.id.nomtachedetailpre);
        title = findViewById(R.id.titlepre);
        startDate = findViewById(R.id.starttachedetailpre);
        userFk= findViewById(R.id.userFkpre);
        isdone= findViewById(R.id.isdone);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");
       id.setText(presence.tacheArrayList.get(position).getTasksID());
        startDate.setText(presence.tacheArrayList.get(position).getStartDate());
        title.setText(presence.tacheArrayList.get(position).getTitle());
        userFk.setText(presence.tacheArrayList.get(position).getUser_Fk());
        isdone.setText(presence.tacheArrayList.get(position).getIsDone());
    }
}