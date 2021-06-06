package com.example.lkhayal_salarie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MyAdapterListseance extends ArrayAdapter<seance> {
    Context context;
    List<seance> arrayListseance;


    public MyAdapterListseance(@NonNull Context context, List<seance> arrayListseance){
        super(context, R.layout.activity_list_c,arrayListseance) ;
        this.context = context;
        this.arrayListseance = arrayListseance;
    }
    @NonNull
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_c,null,true);
        TextView tvID = view.findViewById(R.id.txt1);
        tvID.setText(arrayListseance.get(position).getSeanceID());

        return view;
    }
}
