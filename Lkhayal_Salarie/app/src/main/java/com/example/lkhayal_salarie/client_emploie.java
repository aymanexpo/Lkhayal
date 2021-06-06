package com.example.lkhayal_salarie;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class client_emploie extends AppCompatActivity {
    ListView listView;
    MyAdapterListseance adapter;
    TextView total;
    ProgressDialog p;
    public static ArrayList<seance> seanceArrayList = new ArrayList<>();
    seance s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_emploie);
        ImageView retour = findViewById(R.id.retourimg);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), client_dashboard.class);
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
        CardView AJOUTERseance = findViewById(R.id.Futureseances);
        AJOUTERseance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), futureseances.class);
                startActivityForResult(myIntent, 0);
                finish();
            }
        });
        listView =findViewById(R.id.listeseance);
        adapter = new MyAdapterListseance(this,seanceArrayList);
        listView.setAdapter(adapter);
        total = findViewById(R.id.sumSeanceint);
        listseance();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                ProgressDialog progressDialog = new ProgressDialog(view.getContext());
                CharSequence[] dialogItem = {"Détail seance","Supprimer Cette seance"};
                builder.setTitle(seanceArrayList.get(position).getSeanceID() + "  " + seanceArrayList.get(position).getComments());
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        switch (i) {
                            case 0:
                                startActivity(new Intent(client_emploie.this,detailseance.class).putExtra("position",position));
                                break;
                            case 1:
                                startActivity(new Intent(client_emploie.this,supprimerseance.class).putExtra("position",position));
                        }
                    }
                });
                builder.create().show();
            }
        });
    }
    public void listseance(){
        StringRequest request = new StringRequest(Request.Method.POST,MainActivity.urlSeanceliste, new Response.Listener<String>() {
            public void onResponse(String response){
                seanceArrayList.clear();
                try{
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("seances");
                    if(success.equals("1")){
                        int x = jsonArray.length();
                        total.setText(x+"");
                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject object = jsonArray.getJSONObject(i);
                            String seanceID = object.getString("seanceID");
                            String monitorID = object.getString("monitorID");
                            String clientID = object.getString("clientID");
                            String startDate  = object.getString("startDate");
                            String durationMinut = object.getString("durationMinut");
                            String  comments= object.getString("comments");
                            s =new seance(seanceID,monitorID,clientID,startDate,durationMinut,comments);
                            seanceArrayList.add(s);
                            adapter.notifyDataSetChanged();
                        }
                    }}
                catch( JSONException e){
                    e.printStackTrace();
                }
            }
        },new Response.ErrorListener(){
            public void onErrorResponse(VolleyError error){
                Toast.makeText(client_emploie.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}