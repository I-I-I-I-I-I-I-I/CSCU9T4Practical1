package com.stir.cscu9t4practical1;

import java.util.Calendar;

public class sprintEntry extends Entry{

    private String runDistance;
    private int quant;
    private int restM;


    public sprintEntry(String n, int d, int m, int y, int h, int min, int s, String dist , int howMany , int restMin) {

        name = n;
        dateAndTime = Calendar.getInstance();
        dateAndTime.set(y,m,d,h,min,s);
        runDistance = dist;
        restM = restMin;
        quant = howMany;
        
    }
    
}
