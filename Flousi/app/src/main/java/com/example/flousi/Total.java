package com.example.flousi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.flousi.MainActivity.db;
import static com.example.flousi.MainActivity.getAppFirstInstallTime;
import static com.example.flousi.MainActivity.getDate;

public class Total extends AppCompatActivity {

    TextView total,datev;
    Long date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);
        total=findViewById(R.id.t);
        total.setText(Float.toString(db.total()));
        date=getAppFirstInstallTime(this);
        String d = getDate(date, "dd/MM/yyyy");
        datev=findViewById(R.id.date);
        datev.setText(d);
    }

    @Override
    public void onResume(){
        super.onResume();
        total.setText(Float.toString(db.total()));
    }

}






