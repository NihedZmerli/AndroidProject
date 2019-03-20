package com.example.flousi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Model {
    private String achat;
    String date;
    public static float total;
    private float prix;
    private int id;

    Model(){ }

    public Model(String achat,float prix) {
        this.achat = achat;
        this.prix = prix;
        String d = "MM/dd/yyyy HH:mm:ss";

        DateFormat df = new SimpleDateFormat(d);
        Date today = Calendar.getInstance().getTime();

        date = df.format(today);
    }

    public String getAchat() {
        return achat;
    }

    public void setAchat(String achat) {
        this.achat = achat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}



