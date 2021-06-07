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

public class listsalarie extends AppCompatActivity {



        ListView listView;
        MyAdaptersalarie adapter;
        TextView total;
        ProgressDialog p;



        public static ArrayList<user> salarieArrayList = new ArrayList<>();
        String url = MainActivity.urlListUser;
        user u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listsalarie);
        ImageView retour = findViewById(R.id.retourimg);

        p = new ProgressDialog(this);

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

        CardView ajoutersalarie = findViewById(R.id.cardajouterS);
        ajoutersalarie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), ajoutersalarie.class);
                startActivityForResult(myIntent, 0);
                finish();
            }
        });



    listView =findViewById(R.id.listesalarie);
    adapter = new MyAdaptersalarie(this,salarieArrayList);
      listView.setAdapter(adapter);
    total = findViewById(R.id.sumSalarieint);
    listsalarie();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            ProgressDialog progressDialog = new ProgressDialog(view.getContext());

            CharSequence[] dialogItem = {"Détail salarie","Supprimer Ce salarie", "Modifier Salarie"};
            builder.setTitle(salarieArrayList.get(position).getUserFName() + "  " + salarieArrayList.get(position).getUserLName());
            builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    switch (i) {

                        case 0:
                            startActivity(new Intent(listsalarie.this,detailsalarie.class).putExtra("position",position));
                            break;
                        case 1:
                            startActivity(new Intent(listsalarie.this,supprimersalarie.class).putExtra("position",position));
                            break;
                        case 2 :
                            startActivity(new Intent(listsalarie.this,modifiersalarie.class).putExtra("position",position));
                    }
                }
            });
            builder.create().show();

        }
    });
}
    public void listsalarie(){
        StringRequest request = new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
            public void onResponse(String response){



                salarieArrayList.clear();
                try{

                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");

                    JSONArray jsonArray = jsonObject.getJSONArray("user");

                    if(success.equals("1")){


                        int x = jsonArray.length();
                        total.setText(x+"");

                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject object = jsonArray.getJSONObject(i);
                            String userID = object.getString("userID");
                            String fName = object.getString("userFName");
                            String lName = object.getString("userLName");
                            String Email  = object.getString("userEmail");
                            String passwd  = object.getString("userPasswd");
                            String  Phone= object.getString("userPhone");


                            u =new user(userID,Email,passwd,fName,lName,Phone);
                            salarieArrayList.add(u);
                            adapter.notifyDataSetChanged();
                        }

                    }}
                catch( JSONException e){
                    e.printStackTrace();
                }

            }
        },new Response.ErrorListener(){
            public void onErrorResponse(VolleyError error){
                Toast.makeText(listsalarie.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}