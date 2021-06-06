package com.example.lkhayal_admin;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class ajoutersalarie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajoutersalarie);

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

        EditText nom, prenom, email, password, tele;
        Button btnEnregistrer;

        nom = findViewById(R.id.nomsalarie);
        prenom = findViewById(R.id.prenomsalarie);
        email = findViewById(R.id.emailsalarie);
        password = findViewById(R.id.motDePasseSalarie);
        tele = findViewById(R.id.telesalarie);


        btnEnregistrer = findViewById(R.id.Btnenregistrersalarie);

        btnEnregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String  nom1, prenom1, email1, password1, tele1;
                nom1  = nom.getText().toString();
                prenom1= prenom.getText().toString();
                email1 = email.getText().toString();
                password1= password.getText().toString();
                tele1 = tele.getText().toString();

                if(!nom1.equals("") && !prenom1.equals("") && !email1.equals("")&& !password1.equals("")&& !tele1.equals("")){

                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[5];

                            field[0] = "userLName";
                            field[1] = "userFName";
                            field[2] = "userEmail";
                            field[3] = "userPasswd";
                            field[4] = "userPhone";

                            //Creating array for data
                            String[] data = new String[5];
                            data[0] = nom1;
                            data[1] = prenom1;
                            data[2] = email1;
                            data[3] = password1;
                            data[4] = tele1;


                            PutData putData = new PutData("http://192.168.1.109:8080/LoginRegiter/signup.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if (result.equals("Sign Up Success")) {
                                        Intent intent = new Intent(getApplicationContext(), listsalarie.class);
                                        startActivity(intent);
                                        finish();
                                    } else {

                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    }

                                }

                                //End Write and Read data with URL
                            }}
                    });
                }
                else{
                    Toast.makeText(getApplication(),"All fields are required", Toast.LENGTH_SHORT).show();

                }
                }

        });
    }
}