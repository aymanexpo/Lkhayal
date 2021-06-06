package com.example.lkhayal_client;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    static String url = "http://192.168.0.107:8080/LoginRegiter/";
    static String url1 = url+"loginclient.php";
    static String urlSeanceliste = url+"listeseanceclient.php";
    static String urlseancefuture = url+"futureseances.php";
    static String urlsupprimseance = url+"supprimerseance.php";
    static String urllistenote = url+"listnots.php";
    static String urlajoutnote = url+"ajouternote.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}