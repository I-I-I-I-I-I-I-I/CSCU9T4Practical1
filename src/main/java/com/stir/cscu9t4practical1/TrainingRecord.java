// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;




import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
   public void addEntry(Entry e){
    if(tr.size() >= 1)
        {
        for(int x = 0 ; x < tr.size() ; x++)
            {
                Entry compare = tr.get(x);
                if(compare.getName().equalsIgnoreCase(e.getName()) && compare.getDay() == e.getDay() && compare.getMonth() == e.getMonth() && compare.getYear() == e.getYear())
                    {
                        TrainingRecordGUI.duplicateWarn();
                    }
                else 
                    {
                        tr.add(e);
                     }

            }
        }
    else{
        tr.add(e);
        TrainingRecordGUI.lookUpByDate.setEnabled(true);
        TrainingRecordGUI.findAllByDate.setEnabled(true);
        TrainingRecordGUI.removeEntry.setEnabled(true);
    }
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

   public void removeEntry(String name , int d , int m , int y){

        ListIterator<Entry> iter = tr.listIterator();
        int counter = 0;
        while(iter.hasNext()){
            Entry current = iter.next();

                if (current.getDay()==d && current.getMonth()==m && current.getYear()==y && current.getName() == name) 
                    {
                        tr.remove(counter);
                    }

        }
        counter++;
   }
   
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   
} // TrainingRecord