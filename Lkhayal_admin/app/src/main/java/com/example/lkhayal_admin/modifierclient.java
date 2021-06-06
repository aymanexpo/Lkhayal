
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

public class modifierclient extends AppCompatActivity {
    int position  ;
    EditText Nom , Prenom , Email , Password, Tele;
    Button BtnSave ;
    private String id ;

    private static String URL_UPDATE = "http://192.168.43.183:8080/LoginRegiter/modifier.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifierclient);

        Nom = findViewById(R.id.nomclientmodifier);
        Prenom = findViewById(R.id.prenomclientmodifier);
        Email = findViewById(R.id.emailclientmodifier);
        Password = findViewById(R.id.motDePasseclientmodifier);
        Tele = findViewById(R.id.teleclientemodifier);
        BtnSave = findViewById(R.id.Btnenregistrermodification);

        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Nom.getText().toString().isEmpty()) {
                    Nom.setError("Le champs de nom du client est obligatoire");
                }
                if (Prenom.getText().toString().isEmpty()) {
                    Prenom.setError("Le champs  prénom du client est obligatoire");
                }
                if (Email.getText().toString().isEmpty()) {
                    Email.setError("Le champs login du cliente est obligatoire");
                }
                if (Password.getText().toString().isEmpty()) {
                    Password.setError("Le mot de passe du client est obligatoire");
                }
                if (Tele.getText().toString().isEmpty()) {
                    Tele.setError("Le mot de passe du client est obligatoire");
                }
                modifierclient();
                startActivity(new Intent(modifierclient.this, Listclient.class));
            }
        });

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        id = Listclient.clientArrayList.get(position).getClientID() ;
        Toast.makeText(modifierclient.this, id, Toast.LENGTH_SHORT).show();

        Nom.setText(Listclient.clientArrayList.get(position).getlName());
        Prenom.setText(Listclient.clientArrayList.get(position).getfName());
        Email.setText(Listclient.clientArrayList.get(position).getClientEmail());
        Password.setText(Listclient.clientArrayList.get(position).getPasswd());
        Tele.setText(Listclient.clientArrayList.get(position).getClientPhone());

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

    private void modifierclient() {
        final String nom = this.Nom.getText().toString().trim();
        final String prenom = this.Prenom.getText().toString().trim();
        final String email = this.Email.getText().toString().trim();
        final String password = this.Password.getText().toString().trim();
        final String tele = this.Tele.getText().toString().trim();

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_UPDATE,
                response -> {
                    if (response.trim().equals("1")) {
                        Toast.makeText(getApplicationContext(), "le client est modifier!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "le client n'a pas modifier!", Toast.LENGTH_LONG).show();
                    }
                },
                error -> Toast.makeText(modifierclient.this, "Add Error!" + error.toString(), Toast.LENGTH_SHORT).show()) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("clientID",id);
                params.put("lName", nom);
                params.put("fName", prenom);
                params.put("clientEmail",  email);
                params.put("passwd", password);
                params.put("clientPhone", tele);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

}