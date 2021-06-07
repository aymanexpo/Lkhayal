package com.example.lkhayal_admin;

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

public class presence extends AppCompatActivity {
    ListView listView;
    MyAdapterlisttache adapter;
    TextView total;
    ProgressDialog p;



    public static ArrayList<tache> tacheArrayList = new ArrayList<>();
    String url = MainActivity.urllistdesabsences;
    tache t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presence);

        ImageView retour = findViewById(R.id.retourimg);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), admindashboard.class);
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

        p = new ProgressDialog(this);

        listView =findViewById(R.id.listeabsent);
        adapter = new MyAdapterlisttache(this,tacheArrayList);
        listView.setAdapter(adapter);
        total = findViewById(R.id.sumabsentint );
        listabsent();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                ProgressDialog progressDialog = new ProgressDialog(view.getContext());

                CharSequence[] dialogItem = {"Détail "};
                builder.setTitle(tacheArrayList.get(position).getTitle());
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        switch (i) {

                            case 0:
                                startActivity(new Intent(presence.this,detailpresent.class).putExtra("position",position));
                                break;
                        }
                    }
                });
                builder.create().show();

            }
        });
    }
    public void listabsent(){
        StringRequest request = new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
            public void onResponse(String response){



                tacheArrayList.clear();
                try{

                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");

                    JSONArray jsonArray = jsonObject.getJSONArray("tasks");

                    if(success.equals("1")){


                        int x = jsonArray.length();
                        total.setText(x+"");

                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject object = jsonArray.getJSONObject(i);
                            String taskID = object.getString("taskID");
                            String startdate = object.getString("startDate");
                            String title  = object.getString("title");
                            String  user_Fk = object.getString("user_Fk");
                            String  isDone = object.getString("isDone");


                            t =new tache(taskID,startdate,title,isDone,user_Fk);
                            tacheArrayList.add(t);
                            adapter.notifyDataSetChanged();
                        }

                    }}
                catch( JSONException e){
                    e.printStackTrace();
                }

            }
        },new Response.ErrorListener(){
            public void onErrorResponse(VolleyError error){
                Toast.makeText(presence.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}