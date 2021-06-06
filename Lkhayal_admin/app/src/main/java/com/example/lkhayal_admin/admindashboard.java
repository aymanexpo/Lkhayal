package com.example.lkhayal_admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class admindashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admindashboard);




        ImageView client = findViewById(R.id.client);
        client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Listclient.class);
                startActivityForResult(myIntent, 0);
                finish();
            }
        });
        TextView txtClient = findViewById(R.id.txtclient);
        txtClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Listclient.class);
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





        ImageView seance = findViewById(R.id.seance);
        seance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), listeseance.class);
                startActivityForResult(myIntent, 0);
                finish();
            }
        });
        TextView txtseance = findViewById(R.id.txtsence);
        txtseance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), listeseance.class);
                startActivityForResult(myIntent, 0);
                finish();
            }
        });


        ImageView salarie = findViewById(R.id.salarie);
        salarie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), listsalarie.class);
                startActivityForResult(myIntent, 0);
                finish();
            }
        });
        TextView txtsalarie = findViewById(R.id.txtsalarie);
        txtsalarie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), listsalarie.class);
                startActivityForResult(myIntent, 0);
                finish();
            }
        });


        ImageView tache = findViewById(R.id.tache);
        tache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), listtache.class);
                startActivityForResult(myIntent, 0);
                finish();
            }
        });
        TextView txttache = findViewById(R.id.txttache);
        txttache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), listtache.class);
                startActivityForResult(myIntent, 0);
                finish();
            }
        });


        ImageView note = findViewById(R.id.note);
        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), listNote.class);
                startActivityForResult(myIntent, 0);
                finish();
            }
        });
        TextView txtnote = findViewById(R.id.txtnote);
        txtnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), listNote.class);
                startActivityForResult(myIntent, 0);
                finish();
            }
        });


        ImageView presence = findViewById(R.id.presence);
        presence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), presence.class);
                startActivityForResult(myIntent, 0);
                finish();
            }
        });
        TextView txtpresence = findViewById(R.id.txtpresence);
        txtpresence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), presence.class);
                startActivityForResult(myIntent, 0);
                finish();
            }
        });
    }
}