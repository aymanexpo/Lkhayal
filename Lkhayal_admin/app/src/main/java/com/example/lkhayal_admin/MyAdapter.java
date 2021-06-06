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

public class MyAdapter extends ArrayAdapter<client> {

    Context context;
    List<client> arrayListclient;



    public MyAdapter(@NonNull Context context, List<client>arrayListclient) {
        super(context, R.layout.activity_list_c,arrayListclient);

        this.context = context;
        this.arrayListclient = arrayListclient;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_c,null,true);
       TextView tvName =view.findViewById(R.id.txt1);

        tvName.setText(arrayListclient.get(position).getlName());

        return view;
    }
}
