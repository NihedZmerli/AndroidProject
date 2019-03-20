package com.example.flousi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.flousi.MainActivity.db;

public class Add_Flous extends AppCompatActivity {

    EditText add;
    EditText prixadd;
    Button btnadd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__flous);
        add=findViewById(R.id.ch1);
        prixadd=findViewById(R.id.ch2);
        btnadd=findViewById(R.id.b);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String chrit=add.getText().toString();
                Float prix= Float.valueOf( prixadd.getText().toString());
                Model achat = new Model(chrit,prix);
                db.ajouter_achat(achat);

                Toast.makeText(Add_Flous.this, "Achat ajouté", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Add_Flous.this, MainActivity.class);
                startActivity(intent);
            }

            });
        }





}

