package com.example.lkhayal_admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class detailsalarie extends AppCompatActivity {
    int position;
    EditText  userEmail, userFName, userLName, userPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailsalarie);



        ImageView retour = findViewById(R.id.retourimg);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), listsalarie.class);
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

        userEmail = findViewById(R.id.emailsalariedetail);
       // usertype= findViewById(R.id.typesalarie);
        userFName = findViewById(R.id.prenomsalariedeatail);
        userLName = findViewById(R.id.nomsalariedetail);
        userPhone = findViewById(R.id.telesalariedetail);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        userEmail.setText(listsalarie.salarieArrayList.get(position).getUserEmail());
        //usertype.setText(listsalarie.salarieArrayList.get(position).getUserType());
        userFName.setText(listsalarie.salarieArrayList.get(position).getUserFName());
        userLName.setText(listsalarie.salarieArrayList.get(position).getUserLName());
        userPhone.setText(listsalarie.salarieArrayList.get(position).getUserPhone());

    }
}