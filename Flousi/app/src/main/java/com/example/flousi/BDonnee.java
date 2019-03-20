package com.example.flousi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class BDonnee extends SQLiteOpenHelper {

    public BDonnee( Context context) {
        super(context, "Achats", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table="CREATE TABLE Achats(id integer primary key ,achat text,prix float,date text)";
        db.execSQL(table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String delete="DROP TABLE IF EXISTS Achats";
        db.execSQL(delete);
        onCreate(db);

    }

    public void ajouter_achat( Model model ) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("achat", model.getAchat());
        contentValues.put("date", model.getDate());
        contentValues.put("prix", model.getPrix());

        db.insert("Achats", null,contentValues);
    }

    public ArrayList<Model> afficher_achat(){

        SQLiteDatabase db = getReadableDatabase();
        String selectall= "SELECT * FROM Achats";
        Cursor cursor= db.rawQuery(selectall,null);
        ArrayList<Model> achats= new ArrayList<>();

        if (cursor.moveToFirst()){
            do {
                Model achat = new Model(cursor.getString(1),cursor.getFloat(2));
                achat.setId((cursor.getInt(0)));
                achat.setDate(cursor.getString(3));
                achats.add(achat);

            }while (cursor.moveToNext());

        }
        return achats;

    }

    public void remove(int id){
        SQLiteDatabase db=getWritableDatabase();
        db.delete("Achats","id="+Integer.toString(id),null);}

    public Float total()
    {   Float s =0f ;

        SQLiteDatabase db=getReadableDatabase();
        String selectall="SELECT * FROM Achats";
        Cursor cursor= db.rawQuery(selectall,null);
        ArrayList<Model> achats=new ArrayList<>();
        if (cursor.moveToFirst()){
            do{
                s+=cursor.getFloat(2);
            }
            while(cursor.moveToNext());
        }

        return s ;}



}








