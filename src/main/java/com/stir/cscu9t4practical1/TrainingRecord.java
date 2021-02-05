// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;




import java.util.*;


public class TrainingRecord  {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
   public void addEntry(Entry e){
       tr.add(e);    
   } // addClass

   public String lookupAll (int d , int m , int y)
    {

        ListIterator<Entry> iter = tr.listIterator();
        String all;
        String noValue = "No entries found for this date.";
        StringBuilder allBuild = new StringBuilder();
        boolean check = true;

        while(iter.hasNext())
            {          
                Entry currentValue = iter.next();
                int monthCheck = currentValue.getMonth();
                int dayCheck = currentValue.getDay();
                int yearCheck = currentValue.getYear();
                
             if (currentValue.getDay()==d && currentValue.getMonth()==m && currentValue.getYear() == y)
                
                {
                    allBuild.append(currentValue.getEntry() + " \n");   
                }

                check = false;

            }

        all = allBuild.toString();

        if (check == false)
            {
                 return all;
            }
        else
            {
                return noValue;
            }
    }
   
   // look up the entry of a given day and month
   public String[] lookupEntry (int d, int m, int y) {

       ListIterator<Entry> iter = tr.listIterator();
       String[] result = {"No entries found" , ""};
       int ifCounter = 0;

       while (iter.hasNext()) {

          Entry current = iter.next();

                if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
                    {
                        ifCounter++;
                        if(ifCounter > 0)
                            {
                                result[1] = "trigger";
                            }

                        result[0] = current.getEntry();
                        
                    }
                    
        }
       return result;
   } // lookupEntry
   
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   
} // TrainingRecord