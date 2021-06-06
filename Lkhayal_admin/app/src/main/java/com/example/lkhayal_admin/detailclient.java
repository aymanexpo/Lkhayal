
package com.example.lkhayal_admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class detailclient extends AppCompatActivity {

    int position;
    EditText nom,prenom , email, tele;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailclient);
         nom = findViewById(R.id.nomclientdetail);
         prenom= findViewById(R.id.prenomdetail);
         email= findViewById(R.id.usernamedetail);
         tele= findViewById(R.id.teleclientedetail);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");
        nom.setText(Listclient.clientArrayList.get(position).getfName());
        prenom.setText(Listclient.clientArrayList.get(position).getlName());
        email.setText(Listclient.clientArrayList.get(position).getClientEmail());
        tele.setText(Listclient.clientArrayList.get(position).getClientPhone());


        ImageView retour = findViewById(R.id.retourimg);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Listclient.class);
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