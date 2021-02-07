package com.stir.cscu9t4practical1;

public class sprintEntry extends Entry{

    private int quant;
    private int restM;


    public sprintEntry(String n, int d, int m, int y, int h, int min, int s, String dist , int howMany , int restMin) {
        super(n, d, m, y, h, min, s, dist);

        restM = restMin;
        quant = howMany;
        
    }

    public int getAmount(){
        return quant;
    }

    public int getRestTime(){
        return restM;
    }

    public String getEntry () {
        String result = getName()+" ran " + getDistance() + " km in "
                  +getHour()+":"+getMin()+":"+ getSec() + " on "
                  +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
        return result;
 
    }
}
