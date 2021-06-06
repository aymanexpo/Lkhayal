package com.example.lkhayal_admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MyAdaptersalarie extends ArrayAdapter {
    Context context;
    List<user> arrayListUsers;

    public MyAdaptersalarie(@NonNull Context context, List<user> arrayListUsers){
       super(context, R.layout.activity_list_c,arrayListUsers) ;
       this.context = context;
       this.arrayListUsers = arrayListUsers;
    }
    @NonNull
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_c,null,true);
        TextView tvID = view.findViewById(R.id.txt1);
        tvID.setText(arrayListUsers.get(position).getUserID());

        return view;
    }



}
