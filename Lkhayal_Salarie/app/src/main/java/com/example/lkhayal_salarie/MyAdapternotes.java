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

public class MyAdapternotes extends ArrayAdapter {

  Context context;
  List<com.example.lkhayal_client.Note> arrayListNote;

public MyAdapternotes(@NonNull Context context, List<com.example.lkhayal_client.Note> arrayListNote){
  super(context, R.layout.activity_list_c,arrayListNote) ;
  this.context = context;
  this.arrayListNote = arrayListNote;
}

  @NonNull
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_c,null,true);
      TextView tvID = view.findViewById(R.id.txt1);
      tvID.setText(arrayListNote.get(position).getClientID());

      return view;
  }

}
