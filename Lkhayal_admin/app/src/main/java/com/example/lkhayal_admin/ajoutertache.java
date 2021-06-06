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

public class ajoutertache extends AppCompatActivity {
    private Spinner spinner;
    public  int nbrSal ;
    public static ArrayList<user> userArrayList = new ArrayList<>();
    public ArrayList<String> arrayList = new ArrayList<>();
    public ArrayList<String> positionlist = new ArrayList<>();
    user utilisateur;
    public String  id_user = "null" ;
    private static String URL= "http://192.168.150.1:8080/LoginRegiter/listUSER.php";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajoutertache);

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
        DatePickerDialog.OnDateSetListener setListener;
        final String[] date = new String[1];
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month =calendar.get(calendar.MONTH);
        final int day = calendar.get(calendar.DAY_OF_MONTH);


        EditText starttache, dureetache, detail, title;
        Spinner user_fk;
        Button btnEnregistrer;

        title= findViewById(R.id.nomtache);
        starttache = findViewById(R.id.starttache);
        dureetache = findViewById(R.id.dureetache);
        detail = findViewById(R.id.detailtache);
        user_fk = (Spinner) findViewById(R.id.idsalarie);



        starttache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        ajoutertache.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {

                        month= month+1;
                        date[0] = year+"-"+month+"-"+day;
                        starttache.setText(date[0]);
                    }
                },year,month,day);
                datePickerDialog.show();

            }
        });


        spinner = findViewById(R.id.idsalarie);
        listsalarie();
        arrayList.add("Choisir un Salarie");
        positionlist.add("null");



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



        btnEnregistrer = findViewById(R.id.Btnenregistrertache);

        btnEnregistrer.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {

                                                  String nom, start, dure, det, user_FK;


                                                  start = date[0];
                                                  dure = dureetache.getText().toString();
                                                  nom = title.getText().toString();
                                                  det = detail.getText().toString();
                                                  user_FK=id_user;

                                                  Handler handler = new Handler();
                                                  handler.post(new Runnable() {
                                                      @Override
                                                      public void run() {

                                                          String[] field = new String[5];

                                                          field[0] = "startDate";
                                                          field[1] ="durationMinut";
                                                          field[2] = "title";
                                                          field[3] = "detail";
                                                          field[4] = "user_Fk";


                                                          String[] data = new String[5];
                                                          data[0] = nom;
                                                          data[1] = start;
                                                          data[2] = dure;
                                                          data[3] = det;
                                                          data[4] = user_FK;



                                                          PutData putData = new PutData("http://192.168.150.1:8080/LoginRegiter/ajoutertache.php", "POST", field, data);
                                                          if (putData.startPut()) {
                                                              if (putData.onComplete()) {
                                                                  String result = putData.getResult();
                                                                  if (result.equals("Sign Up Success")) {
                                                                      Intent intent = new Intent(getApplicationContext(), listtache.class);
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
                Toast.makeText(ajoutertache.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }


}