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

public class modifiertache extends AppCompatActivity {

    int position  ;
    EditText date , duree , tit , det, userfk;
    Button BtnSave ;
    private String id ;

    private static String URL_UPDATE = "http://192.168.43.183:8080/LoginRegiter/modifiertache.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifiertache);


        ImageView retour = findViewById(R.id.retourimg);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), listtache.class);
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

        date  = findViewById(R.id.starttachemodifier);
        duree  = findViewById(R.id.dureetachemodifier);
        tit = findViewById(R.id.nomtachemodifier);
        det = findViewById(R.id.detailtachemodifier);
        userfk = findViewById(R.id.userFkmodifier);
        BtnSave = findViewById(R.id.Btnenregistrertachemodifier);

        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifiertache();
                startActivity(new Intent(modifiertache.this, listtache.class));
            }
        });

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        id = listtache.tacheArrayList.get(position).getTasksID() ;
        Toast.makeText(modifiertache.this, id, Toast.LENGTH_SHORT).show();

        date.setText(listtache.tacheArrayList.get(position).getStartDate());
        duree.setText(listtache.tacheArrayList.get(position).getDurationMinut());
        tit.setText(listtache.tacheArrayList.get(position).getTitle());
        det.setText(listtache.tacheArrayList.get(position).getDetail());
        userfk.setText(listtache.tacheArrayList.get(position).getUser_Fk());

    }
    private void modifiertache() {
        final String dat = this.date.getText().toString().trim();
        final String dur = this.duree.getText().toString().trim();
        final String ti = this.tit.getText().toString().trim();
        final String de = this.det.getText().toString().trim();
        final String ufk = this.userfk.getText().toString().trim();

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_UPDATE,
                response -> {
                    if (response.trim().equals("1")) {
                        Toast.makeText(getApplicationContext(), "tache est modifier!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "tache n'a pas modifier!", Toast.LENGTH_LONG).show();
                    }
                },
                error -> Toast.makeText(modifiertache.this, "Add Error!" + error.toString(), Toast.LENGTH_SHORT).show()) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("taskID",id);
                params.put("startDate",dat);
                params.put("durationMinut",dur);
                params.put("title",ti);
                params.put("detail",de);
                params.put("user_Fk",ufk);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

}