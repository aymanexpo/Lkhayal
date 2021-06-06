package com.example.lkhayal_admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class detailseance extends AppCompatActivity {
    int position;
    EditText seanceID, clientID, monitorID, comments, startDate, durationMinut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailseance);


        seanceID = findViewById(R.id.idsdeancedetail);
        clientID = findViewById(R.id.idclientdetail);
        monitorID= findViewById(R.id.idsalariedetail);
        startDate = findViewById(R.id.startdatedetail);
        durationMinut = findViewById(R.id.Duredetail);
        comments = findViewById(R.id.descriptiondetail);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");
        seanceID.setText(listeseance.seanceArrayList.get(position).getSeanceID());
        clientID.setText(listeseance.seanceArrayList.get(position).getClientID());
        monitorID.setText(listeseance.seanceArrayList.get(position).getMonitorID());
        startDate.setText(listeseance.seanceArrayList.get(position).getStartDate());
        durationMinut.setText(listeseance.seanceArrayList.get(position).getDuree());
        comments.setText(listeseance.seanceArrayList.get(position).getComments());





            ImageView retour = findViewById(R.id.retourimg);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), listeseance.class);
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
    }
}