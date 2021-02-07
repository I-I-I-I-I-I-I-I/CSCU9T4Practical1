// This class holds information about a single training session
package com.stir.cscu9t4practical1;

import java.util.Calendar;
public class Entry {
  private String name;
  private Calendar dateAndTime;
  private String distance;
  private int date;
  private int month;
  private int year;
  private int hour;
  private int minute;
  private int second;
  
  public Entry (String n, int d, int m, int y, int h, int min, int s, String dist) {

    name = n;
    date = d;
    month = m;
    year = y;
    hour = h;
    minute = m;
    second = s;
    distance = dist;

  } //constructor
  
  public String getName () {
    return name;
  } //getName
  
  public int getDay () {
    return date;
  } //getDay
  
  public int getMonth () {
    return month;
  } //getMonth
  
  public int getYear () {
    return year;
  } //getYear

  public int getHour () {
    return hour;
  } //getHour

  public int getMin () {
    return minute;
  } //getMin

  public int getSec () {
    return second;
  } //getSec

  public String getDistance () {
    return distance;
  } //getYear

  public String getEntry () {
   String result = getName()+" ran " + getDistance() + " km in "
             +getHour()+":"+getMin()+":"+ getSec() + " on "
             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
   return result;
  } //getEntry
   
} // Entry