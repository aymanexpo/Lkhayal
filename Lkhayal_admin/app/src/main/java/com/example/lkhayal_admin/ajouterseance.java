package com.example.lkhayal_admin;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
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
import java.util.Calendar;

public class ajouterseance extends AppCompatActivity  {



    private Spinner spinner;
    private Spinner spinnerclient;

    public  int nbrclient ;
    public  int nbrSal ;

    public static ArrayList<client> clientArrayList = new ArrayList<>();
    public static ArrayList<user> userArrayList = new ArrayList<>();

    public ArrayList<String> clientarrayList = new ArrayList<>();
    public ArrayList<String> arrayList = new ArrayList<>();

    public ArrayList<String> clientpositionlist = new ArrayList<>();
    public ArrayList<String> positionlist = new ArrayList<>();

    client clt;
    user utilisateur;

    public String  id_client= "null" ;
    public String  id_user = "null" ;

    private static String URLclient= "http://192.168.1.109:8080/LoginRegiter/list.php";
    private static String URL= "http://192.168.1.109:8080/LoginRegiter/listMonitor.php";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouterseance);

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


        spinner = findViewById(R.id.idsalarie);
        listsalarie();
        arrayList.add("Choisir un Moniteur");
        positionlist.add("null");

        spinnerclient = findViewById(R.id.idClient);
        listclient();
        clientarrayList.add("Choisir un client");
        clientpositionlist.add("null");


        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tutorialsName = parent.getItemAtPosition(position).toString();

                Toast.makeText(parent.getContext(), positionlist.get(position), Toast.LENGTH_LONG).show();
               id_user  = positionlist.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

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
        final String[] date = new String[1];
        EditText seanceID, startDate, comments,durationMinut;
        Spinner clientID, monitorID;
        Button btnEnregistrer;
        DatePickerDialog.OnDateSetListener setListener;

        seanceID = findViewById(R.id.idsdeance);
        comments = findViewById(R.id.description);
        durationMinut = findViewById(R.id.Dure);
        clientID = (Spinner) findViewById(R.id.idClient);
        monitorID = (Spinner) findViewById(R.id.idsalarie);
        startDate = findViewById(R.id.startdate);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month =calendar.get(calendar.MONTH);
        final int day = calendar.get(calendar.DAY_OF_MONTH);


        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        ajouterseance.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {

                        month= month+1;
                         date[0] = year+"-"+month+"-"+day;
                        startDate.setText(date[0]);
                    }
                },year,month,day);
                datePickerDialog.show();

            }
        });


        btnEnregistrer = findViewById(R.id.Btnenregistrerseance);

        btnEnregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String seance, dure, comment, startdate, client, monitor,c,m;


                seance = seanceID.getText().toString();
                startdate = date[0];
                dure = durationMinut.getText().toString();
                comment = comments.getText().toString();
                client = clientID.getSelectedItem().toString();
                monitor = monitorID.getSelectedItem().toString();
                c=id_client;
                m=id_user;

                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        String[] field = new String[6];

                        field[0] = "seanceID";
                        field[1] = "monitorID";
                        field[2] = "clientID";
                        field[3] = "startDate";
                        field[4] = "durationMinut";
                        field[5] = "comments";

                        String[] data = new String[6];
                        data[0] = seance;
                        data[1] = m;
                        data[2] = c;
                        data[3] = startdate;
                        data[4] = dure;
                        data[5] = comment;


                        PutData putData = new PutData("http://192.168.1.109:8080/LoginRegiter/ajouterseance.php", "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result = putData.getResult();
                                if (result.equals("Sign Up Success")) {
                                    Intent intent = new Intent(getApplicationContext(), listeseance.class);
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

        StringRequest request = new StringRequest(Request.Method.POST,URLclient,
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
                Toast.makeText(ajouterseance.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }



        public void listsalarie(){

            StringRequest request = new StringRequest(Request.Method.POST,URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            userArrayList.clear();
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String success = jsonObject.getString("success");
                                JSONArray jsonArray = jsonObject.getJSONArray("user");

                                if (success.equals("1")) {
                                    nbrSal =  jsonArray.length() ;

                                    for (int i = 0; i < jsonArray.length(); i++) {

                                        JSONObject object = jsonArray.getJSONObject(i);

                                        String id = object.getString("userID");
                                        String nom = object.getString("userFName");
                                        String prenom = object.getString("userLName");
                                        String login =  object.getString("userEmail");
                                        String password = object.getString("userPasswd");
                                        String phone = object.getString("userPhone");

                                        utilisateur = new user(id, nom, prenom , login , password , phone);
                                        userArrayList.add(utilisateur);
                                        arrayList.add(utilisateur.getUserFName());
                                        positionlist.add(utilisateur.getUserID());
                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(ajouterseance.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(request);
        }




    }


