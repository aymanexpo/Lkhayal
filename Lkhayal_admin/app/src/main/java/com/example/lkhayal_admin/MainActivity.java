package com.example.lkhayal_admin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    static String url = "http://192.168.1.109:8080/LoginRegiter/";
    static String urlLogin = url+"login.php";
    static String urlAddclient = url+"addclient.php";
    static String urlList = url+"list.php";
    static String urlAddNote = url+"ajouternote.php";
    static String urlAddSal = url+"signup.php";
    static String urlListMonitor = url+"listMonitor.php";
    static String urlAddSeance = url+"ajouterseance.php";
    static String urlListUser = url+"listUSER.php";
    static String urlAddTask = url+"ajoutertache.php";
    static String urlListSeance = url+"listseance.php";
    static String urlListeance = url+"listnots.php";
    static String urlListSeace = url+"listtache.php";
    static String ureace = url+"modifier.php";
    static String urlLis = url+"modifiertache.php";
    static String istSeace = url+"modifierseance.php";
    static String urSeace = url+"modifiersalarie.php";
    static String urllistdesabsences = url+"listdesabsences.php";
    static String urllistdnces = url+"supprimerseance.php";
    static String urlliesabsences = url+"supprimertache.php";
    static String urlli = url+"supprimer.php";
    static String urllistces = url+"supprimersalarie.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}