package com.stir.cscu9t4practical1;

import java.util.Calendar;

public class CycleEntry extends Entry {

    private String terr;
    private String temp;

    public CycleEntry(String n, int d, int m, int y, int h, int min, int s, String dist , String terrain , String tempo) {

        name = n;
        dateAndTime = Calendar.getInstance();
        dateAndTime.set(y,m,d,h,min,s);
        distance = dist;
        terr = terrain;
        temp = tempo;
        
    }//constructor

    public String getTerrain(){
        return terr;
    }

    public String getTempo(){
        return temp;
    }
    
}
