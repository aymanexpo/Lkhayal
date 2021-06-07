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

public class Listclient extends AppCompatActivity {

    ListView listView;
    MyAdapter adapter;
    TextView total;
    ProgressDialog p;



public static ArrayList<client>  clientArrayList = new ArrayList<>();
String url = MainActivity.urlList;
client c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listclient);
        p = new ProgressDialog(this);

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
        CardView AJOUTERCLIENT = findViewById(R.id.ajouter);
        AJOUTERCLIENT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), ajouterclient.class);
                startActivityForResult(myIntent, 0);
                finish();
            }
        });




      listView =findViewById(R.id.listeclient);
      adapter = new MyAdapter(this,clientArrayList);
      listView.setAdapter(adapter);
     total = findViewById(R.id.sumClientint);
      listclient();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                ProgressDialog progressDialog = new ProgressDialog(view.getContext());

                CharSequence[] dialogItem = {"Détail client","Supprimer Ce Client", "Modifier Client"};
                builder.setTitle(clientArrayList.get(position).getfName() + "  " + clientArrayList.get(position).getfName());
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        switch (i) {

                            case 0:
                                startActivity(new Intent(Listclient.this,detailclient.class).putExtra("position",position));
                                break;
                            case 1:
                                startActivity(new Intent(Listclient.this,supprimerclient.class).putExtra("position",position));
                                break;
                            case 2 :
                                startActivity(new Intent(Listclient.this,modifierclient.class).putExtra("position",position));
                        }
                    }
                });
                builder.create().show();

            }
        });
    }
    public void listclient(){
        StringRequest request = new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
            public void onResponse(String response){



                clientArrayList.clear();
                try{

              JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");

                 JSONArray jsonArray = jsonObject.getJSONArray("clients");

                    if(success.equals("1")){


                        int x = jsonArray.length();
                        total.setText(x+"");

                        for(int i=0;i<jsonArray.length();i++){
                          JSONObject object = jsonArray.getJSONObject(i);
                            String clientID = object.getString("clientID");
                            String fName = object.getString("fName");
                            String lName = object.getString("lName");
                            String clientEmail  = object.getString("clientEmail");
                            String passwd  = object.getString("passwd");
                            String  clientPhone= object.getString("clientPhone");

                            

                       c =new client(clientID,fName,lName,clientEmail,passwd,clientPhone);
                      clientArrayList.add(c);
                      adapter.notifyDataSetChanged();
                    }

                }}
                catch( JSONException e){
                    e.printStackTrace();
                }

            }
        },new Response.ErrorListener(){
            public void onErrorResponse(VolleyError error){
                Toast.makeText(Listclient.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}
