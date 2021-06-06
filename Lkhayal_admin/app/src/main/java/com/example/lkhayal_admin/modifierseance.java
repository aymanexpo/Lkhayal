
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

import java.util.HashMap;
import java.util.Map;

public class modifierseance extends AppCompatActivity {

    int position  ;
    EditText idseance,   idclient, idsalarie, startdate,duremodifier,description ;
    private int mYear, mMonth, mDay;
    private Button Btnmodifier;
    private String id ;
    private static String URL_UPDATE = "http://192.168.43.183:8080/LoginRegiter/modifierseance.php";
    private Object Volley;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifierseance);


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


        idseance = findViewById(R.id.idsdeancemodifier);
        idsalarie = findViewById(R.id.idsalariemodifier);
        idclient = findViewById(R.id.idClientmodifier);
        startdate = findViewById(R.id.startdatemodifier);
        duremodifier = findViewById(R.id.Duremodifier);
        description = findViewById(R.id.descriptionmodifier);
        Btnmodifier = findViewById(R.id.Btnenregistrereanceemodifier);

        Btnmodifier.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               modifierseance();
                                               startActivity(new Intent(modifierseance.this, listeseance.class));
                                           }

                                          }
        );

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        id = listeseance.seanceArrayList.get(position).getSeanceID() ;
        Toast.makeText(modifierseance.this, id, Toast.LENGTH_SHORT).show();

        idseance.setText(listeseance.seanceArrayList.get(position).getSeanceID());
        idsalarie.setText(listeseance.seanceArrayList.get(position).getMonitorID());
        idclient.setText(listeseance.seanceArrayList.get(position).getClientID());
        startdate.setText(listeseance.seanceArrayList.get(position).getStartDate());
        duremodifier.setText(listeseance.seanceArrayList.get(position).getDuree());
        description.setText(listeseance.seanceArrayList.get(position).getComments());

    }
    private void modifierseance() {
        final String idS = this.idseance.getText().toString().trim();
        final String idSA = this.idsalarie.getText().toString().trim();
        final String idC = this.idclient.getText().toString().trim();
        final String date = this.startdate.getText().toString().trim();
        final String dure = this.duremodifier.getText().toString().trim();
        final String desc = this.description.getText().toString().trim();

        RequestQueue requestQueue = com.android.volley.toolbox.Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_UPDATE,
                response -> {
                    if (response.trim().equals("1")) {
                        Toast.makeText(getApplicationContext(), "la seance est modifier!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Seance n'a pas modifier!", Toast.LENGTH_LONG).show();
                    }
                },
                error -> Toast.makeText(modifierseance.this, "Add Error!" + error.toString(), Toast.LENGTH_SHORT).show()) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("seanceID",idS);
                params.put("monitorID", idSA);
                params.put("clientID", idC);
                params.put("startDate",  date);
                params.put("durationMinut", dure);
                params.put("comments", desc);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    }
