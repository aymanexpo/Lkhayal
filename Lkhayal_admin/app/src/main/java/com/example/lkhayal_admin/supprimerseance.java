package com.example.lkhayal_admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class supprimerseance extends AppCompatActivity {

    int position  ;
    TextView Nom;
    Button BtnSupprimerseance;
    private static String id ;
    private static String URL = "http://192.168.1.109:8080/LoginRegiter/supprimerseance.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supprimerseance);

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

        Nom = findViewById(R.id.seanceasupprimer);
        BtnSupprimerseance= findViewById(R.id.Btnsupprimerseance);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        id = listeseance.seanceArrayList.get(position).getClientID() ;

        BtnSupprimerseance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                supprimerseance(listeseance.seanceArrayList.get(position).getSeanceID());
                startActivity(new Intent(supprimerseance.this, Listclient.class));
            }
        });

        Toast.makeText(supprimerseance.this, id, Toast.LENGTH_SHORT).show();

        String seance =listeseance.seanceArrayList.get(position).getSeanceID() +" " + listeseance.seanceArrayList.get(position).getSeanceID();
        Nom.setText(seance);
    }
    private void supprimerseance(final String id) {

        StringRequest request = new StringRequest(Request.Method.POST,URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.equalsIgnoreCase("Yes")){
                            Toast.makeText(supprimerseance.this, "seance supprime", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(supprimerseance.this, listeseance.class));
                        }
                        else{
                            Toast.makeText(supprimerseance.this, "Non supprime", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(supprimerseance.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();
                params.put("seanceID",id);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);


    }
}