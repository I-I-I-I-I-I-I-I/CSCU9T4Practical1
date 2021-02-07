package com.stir.cscu9t4practical1;

public class CycleEntry extends Entry {

    private String terr;
    private String temp;

    public CycleEntry(String n, int d, int m, int y, int h, int min, int s, String dist , String terrain , String tempo) {
        super(n, d, m, y, h, min, s, dist);

        terr = terrain;
        temp = tempo;
        
    }//constructor

    public String getTerrain(){
        return terr;
    }

    public String getTempo(){
        return temp;
    }

    public String getEntry () {
        String result = getName()+" cycled " + getDistance() + " in "
                  +getHour()+":"+getMin()+":"+ getSec() + " on "
                  +getDay()+"/"+getMonth()+"/"+getYear()+ ". They cycled on "+getTerrain()+ " terrain, at a "+getTempo()+" tempo."+ "\n";
        return result;
    
    }
}
