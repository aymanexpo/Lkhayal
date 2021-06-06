package com.example.lkhayal_salarie;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class activity_login extends AppCompatActivity {


    EditText username, motDePasse;
    Button btnLogin;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        motDePasse = findViewById(R.id.motDePasse);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String clientEmail, passwd;
                clientEmail= username.getText().toString();
                passwd = motDePasse.getText().toString();

                if(!clientEmail.equals("") && !passwd.equals("")){

                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[2];
                            field[0] = "clientEmail";
                            field[1] = "passwd";
                            //Creating array for data
                            String[] data = new String[2];
                            data[0] = clientEmail;
                            data[1] = passwd;
                            PutData putData = new PutData(MainActivity.url1, "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if (result.equals("connecter")) {
                                        Intent intent = new Intent(getApplicationContext(), client_dashboard.class);
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

                }}
        });



    }}