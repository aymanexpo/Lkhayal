package com.example.lkhayal_admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class detailstache extends AppCompatActivity {
    int position;
    EditText title, detail, startDate, durationMinut, userFk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailstache);

        ImageView retour = findViewById(R.id.retourimg);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), listtache.class);
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


        title = findViewById(R.id.nomtachedetail);
        detail= findViewById(R.id.detailtachedetail);
        startDate = findViewById(R.id.starttachedetail);
        durationMinut = findViewById(R.id.dureetachedetail);
        userFk= findViewById(R.id.userFk);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");
        title.setText(listtache.tacheArrayList.get(position).getTitle());
        detail.setText(listtache.tacheArrayList.get(position).getDetail());
        startDate.setText(listtache.tacheArrayList.get(position).getStartDate());
        durationMinut.setText(listtache.tacheArrayList.get(position).getDurationMinut());
        userFk.setText(listtache.tacheArrayList.get(position).getUser_Fk());

    }
}