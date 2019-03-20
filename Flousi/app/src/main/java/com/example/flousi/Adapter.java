package com.example.flousi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter  extends ArrayAdapter<Model> {
    private ArrayList<Model> arrayList;
    private Context p ;
    private int item;
    public Adapter(@NonNull Context context, int resource, ArrayList<Model> liste) {
        super(context, resource, liste);
        this.arrayList = liste;
        this.p = context;
        this.item = resource;
    }

    public boolean isEnabled(int position)
    {
        return true;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(p).inflate(item,parent,false);
        TextView achat=convertView.findViewById(R.id.text1);
        TextView date=convertView.findViewById(R.id.text2);
        TextView prix=convertView.findViewById(R.id.p);

        achat.setText(arrayList.get(position).getAchat());
        date.setText(arrayList.get(position).getDate());
        prix.setText(Float.toString(arrayList.get(position).getPrix()));

        return convertView;
    }

}
