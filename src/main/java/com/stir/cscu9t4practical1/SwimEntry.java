package com.stir.cscu9t4practical1;

public class SwimEntry extends Entry {

    private String insideOutside;

    public SwimEntry(String n, int d, int m, int y, int h, int min, int s, String dist , String inOut)
        {
            super(n, d, m, y, h, min, s, dist);

            insideOutside = inOut;

        }

    public String getInOut()
    {
        return insideOutside;
    }

    //"Swam" or "swimmed"????
    public String getEntry () {
        String result = getName()+" swam " + getDistance() + " in "
                  +getHour()+":"+getMin()+":"+ getSec() + " on "
                  +getDay()+"/"+getMonth()+"/"+getYear()+ ". They swam "+ insideOutside+".\n";
        return result;
    }
    
}
