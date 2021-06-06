package com.example.lkhayal_salarie;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ajouternote extends AppCompatActivity {


    private Spinner spinnerclient;
    public  int nbrclient ;
    public static ArrayList<client> clientArrayList = new ArrayList<>();
    public ArrayList<String> clientarrayList = new ArrayList<>();
    public ArrayList<String> clientpositionlist = new ArrayList<>();
    client clt;

    public String  id_client= "null" ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajouternote);


        ImageView retour = findViewById(R.id.retourimg);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), listnote.class);
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

        spinnerclient = findViewById(R.id.idClient);
        listclient();
        clientarrayList.add("Choisir un client");
        clientpositionlist.add("null");

        final ArrayAdapter<String> clientArrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, clientarrayList);
        clientArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerclient.setAdapter(clientArrayAdapter);
        spinnerclient.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tutorialsName = parent.getItemAtPosition(position).toString();

                Toast.makeText(parent.getContext(), clientpositionlist.get(position), Toast.LENGTH_LONG).show();
                id_client  = clientpositionlist.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        EditText remarque;
        Spinner clientID;
        Button btnEnregistrer;

        clientID = (Spinner) findViewById(R.id.idClient);
        remarque = findViewById(R.id.remarque);
        btnEnregistrer = findViewById(R.id.Btnenregistrernote);


        btnEnregistrer.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {

                                                  String remarq,c;


                                                  remarq = remarque.getText().toString();
                                                  c=id_client;


                                                  Handler handler = new Handler();
                                                  handler.post(new Runnable() {
                                                      @Override
                                                      public void run() {

                                                          String[] field = new String[2];

                                                          field[0] = "clientID";
                                                          field[1] = "notes";

                                                          String[] data = new String[2];
                                                          data[0] = c;
                                                          data[1] = remarq;


                                                          PutData putData = new PutData(MainActivity.urlajoutnote, "POST", field, data);
                                                          if (putData.startPut()) {
                                                              if (putData.onComplete()) {
                                                                  String result = putData.getResult();
                                                                  if (result.equals("Sign Up Success")) {
                                                                      Intent intent = new Intent(getApplicationContext(), listnote.class);
                                                                      startActivity(intent);
                                                                      finish();
                                                                  } else {

                                                                      Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                                                  }

                                                              }


                                                          }
                                                      }
                                                  });
                                              }
                                          }


        );
    }

    public void listclient(){

        StringRequest request = new StringRequest(Request.Method.POST,MainActivity.urlajoutnote,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        clientArrayList.clear();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("clients");

                            if (success.equals("1")) {
                                nbrclient =  jsonArray.length() ;
                                for(int i=0;i<jsonArray.length();i++){

                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String clientID = object.getString("clientID");
                                    String fName = object.getString("fName");
                                    String lName = object.getString("lName");
                                    String clientEmail  = object.getString("clientEmail");
                                    String passwd  = object.getString("passwd");
                                    String  clientPhone= object.getString("clientPhone");



                                    clt = new client(clientID,fName,lName,clientEmail,passwd,clientPhone);
                                    clientArrayList.add(clt);
                                    clientarrayList.add(clt.getlName());
                                    clientpositionlist.add(clt.getClientID());
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ajouternote.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}