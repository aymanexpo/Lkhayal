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

public class supprimerclient extends AppCompatActivity {
    int position  ;
    TextView Nom;
    Button BtnSupprimer;
    private static String id ;
    private static String URL = "http://192.168.1.109:8080/LoginRegiter/supprimer.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supprimerclient);




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

        Nom = findViewById(R.id.clienasupprimer);
        BtnSupprimer= findViewById(R.id.Btnsupprimer);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        id = Listclient.clientArrayList.get(position).getClientID() ;

        BtnSupprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               supprimerclient(Listclient.clientArrayList.get(position).getClientID());
                startActivity(new Intent(supprimerclient.this, Listclient.class));
            }
        });

        Toast.makeText(supprimerclient.this, id, Toast.LENGTH_SHORT).show();

        String client = Listclient.clientArrayList.get(position).getfName() +" " + Listclient.clientArrayList.get(position).getlName();
        Nom.setText(client);
    }
    private void supprimerclient(final String id) {

        StringRequest request = new StringRequest(Request.Method.POST,URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.equalsIgnoreCase("Yes")){
                            Toast.makeText(supprimerclient.this, "client supprime", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(supprimerclient.this, Listclient.class));
                        }
                        else{
                            Toast.makeText(supprimerclient.this, "Non supprime", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(supprimerclient.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();
                params.put("clientID",id);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);


    }

}


