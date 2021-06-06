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

public class MyAdapterlisttache   extends ArrayAdapter<tache> {

        Context context;
        List<tache> arrayListtache;


public MyAdapterlisttache(@NonNull Context context, List<tache> arrayListtache){
        super(context, R.layout.activity_list_c,arrayListtache) ;
        this.context = context;
        this.arrayListtache = arrayListtache;
        }
@NonNull
public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_c,null,true);
        TextView tvID = view.findViewById(R.id.txt1);
        tvID.setText(arrayListtache.get(position).getTitle());

        return view;
        }
}
