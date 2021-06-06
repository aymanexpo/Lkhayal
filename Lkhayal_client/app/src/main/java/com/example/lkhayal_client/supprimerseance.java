package com.example.lkhayal_client;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.supprimerseance);

        ImageView retour = findViewById(R.id.retourimg);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), client_emploie.class);
                startActivityForResult(myIntent, 0);
                finish();
            }
        });
        ImageView Home = findViewById(R.id.Home);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), client_dashboard.class);
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

        id = client_emploie.seanceArrayList.get(position).getClientID() ;

        BtnSupprimerseance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                supprimerseance(client_emploie.seanceArrayList.get(position).getSeanceID());
                startActivity(new Intent(supprimerseance.this, client_emploie.class));
            }
        });

        Toast.makeText(supprimerseance.this, id, Toast.LENGTH_SHORT).show();

        String seance =client_emploie.seanceArrayList.get(position).getSeanceID() +" " + client_emploie.seanceArrayList.get(position).getSeanceID();
        Nom.setText(seance);
    }
    private void supprimerseance(final String id) {

        StringRequest request = new StringRequest(Request.Method.POST,MainActivity.urlsupprimseance,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.equalsIgnoreCase("Yes")){
                            Toast.makeText(supprimerseance.this, "seance supprime", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(supprimerseance.this, client_emploie.class));
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