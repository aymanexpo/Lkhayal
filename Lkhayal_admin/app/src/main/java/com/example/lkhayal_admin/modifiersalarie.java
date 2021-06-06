package com.example.lkhayal_admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class modifiersalarie extends AppCompatActivity {
    int position  ;
    EditText nom , prenom , email , tele,pwd ;
    Button BtnSave ;
    private String id ;
    private static String URL_UPDATE = "http://192.168.1.109:8080/LoginRegiter/modifiersalarie.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifiersalarie);



        nom = findViewById(R.id.nomsalariemodifier);
        prenom = findViewById(R.id.prenomsalariemodifier);
        email = findViewById(R.id.emailsalariemodifier);
        pwd= findViewById(R.id.motDePasseSalariemodifier);
        tele = findViewById(R.id.telesalariemodifier);
        BtnSave = findViewById(R.id.Btnenregistrersalariemodifier);


        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifiersalarie();
                startActivity(new Intent(modifiersalarie.this, listsalarie.class));
            }
        });

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        id = listsalarie.salarieArrayList.get(position).getUserID() ;
        Toast.makeText(modifiersalarie.this, id, Toast.LENGTH_SHORT).show();

        nom.setText(listsalarie.salarieArrayList.get(position).getUserLName());
        prenom.setText(listsalarie.salarieArrayList.get(position).getUserFName());
        email.setText(listsalarie.salarieArrayList.get(position).getUserEmail());
        pwd.setText(listsalarie.salarieArrayList.get(position).getUserPasswd());
        tele.setText(listsalarie.salarieArrayList.get(position).getUserPhone());

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


    }

    private void modifiersalarie() {

        final String nomU = this.nom.getText().toString().trim();
        final String prenomU = this.prenom.getText().toString().trim();
        final String emailU = this.email.getText().toString().trim();
        final String passwordU = this.pwd.getText().toString().trim();
        final String teleU = this.tele.getText().toString().trim();

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_UPDATE,
                response -> {
                    if (response.trim().equals("1")) {
                        Toast.makeText(getApplicationContext(), "le salarie est modifier!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "le salarie n'a pas modifier!", Toast.LENGTH_LONG).show();
                    }
                },
                error -> Toast.makeText(modifiersalarie.this, "Add Error!" + error.toString(), Toast.LENGTH_SHORT).show()) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("userID",id);
                params.put("userLName", nomU);
                params.put("userFName", prenomU);
                params.put("userEmail",  emailU);
                params.put("userPasswd", passwordU);
                params.put("userPhone", teleU);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

}