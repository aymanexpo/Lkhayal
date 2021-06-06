
package com.example.lkhayal_admin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    static String url = "http://192.168.43.32:8080/LoginRegiter/";
    static String url1 = url+"listtache.php";
    static String url2 = url+"login.php";
    static String url3 = url+"addclient.php";
    static String url4 = url+"ajouternote.php";
    static String urlSeanceliste = url+"listseance.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}