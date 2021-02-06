package com.stir.cscu9t4practical1;

import java.util.Calendar;

public class SwimEntry extends Entry {

    private String insideOutside;

    public SwimEntry(String n, int d, int m, int y, int h, int min, int s, String dist , String inOut)
        {

            name = n;
            dateAndTime = Calendar.getInstance();
            dateAndTime.set(y,m,d,h,min,s);
            distance = dist;
            insideOutside = inOut;

        }

    public String getInOut()
    {
        return insideOutside;
    }
    
}
