// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.util.Spliterators.AbstractDoubleSpliterator;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labWarning = new JLabel("More than one record on this date. Showing most recent entry.");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton findAllByDate = new JButton("Find all");
    private JButton showAll = new JButton("Show me All entries on this date");
    public int setLength = 500;
    public int dStore;
    public int mStore;
    public int yStore;
    public List<String> failed = new ArrayList<>();
    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(findAllByDate);
        findAllByDate.addActionListener(this);
        add(showAll);
        showAll.addActionListener(this);
        add(labWarning);
        labWarning.setVisible(false);
        add(outputArea);
        showAll.setVisible(false);
        outputArea.setEditable(false);
        setSize(720, setLength);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry("generic");
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == findAllByDate) {
            message = lookupAll();
        }  
        if (event.getSource() == showAll) {

            message = showAll();
        } 
        outputArea.setText(message);
       blankDisplay();
    } // actionPerformed


    /* Adds the user inputted entries to the system. First line is a method call used to
       verify the numbers as integers using try/catch. Throws an exception if they ain't.
    */
    public String addEntry(String what) {

        boolean[] Vercheck = verify();

        //Integer verification                
                if(Vercheck[0] = true)
                 {
                     JOptionPane.showMessageDialog(null , "The field(s) \n" + failed.toString() + " \n must have an integer value." );
                 }
                if(Vercheck[1] = true)
                 {
                     JOptionPane.showMessageDialog(null , "The field 'name' must have a value." );
                 }


        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        Entry e = new Entry(n, d, m, y, h, mm, s, km);
        myAthletes.addEntry(e);

        return message;
    }
    
    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");

        String returned[] = myAthletes.lookupEntry(d, m, y);

        if (returned[1] == "trigger")
            {
                mStore = m;
                dStore = d;
                yStore = y;
                Warning();
            }

        return myAthletes.lookupEntry(d, m, y)[0];
    }

    /*Looks up and returns all entries for the entered date
      Returns "No entry found" if date has no corresponding data
      boolean atLeastOne checks if there is at least one entry.
    */
    public String lookupAll() {

        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");

        String returner = myAthletes.lookupAll(d , m , y);
        return returner;

    }

    /* If the "lookupEntry" button is clicked and the
       inputted date has more than one entry, this method
       will be invoked and warn the user of that fact.
       Will display a button to give the user the option to
       view all entries for this date (Just calls the lookupAll method above)
    */

    public void Warning()
        {
            labWarning.setVisible(true);
            outputArea.setText("More than one record on this date. Showing most recent entry.");
            showAll.setVisible(true);
        }

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

    //Nothing to see here...
    public String showAll()
        {

                int m = mStore;
                int d = dStore;
                int y = yStore;
        
                return myAthletes.lookupAll(d , m , y);
        
        }

    /*
        Right. This verifies every field* in the program with either a try/catch or
        an if statement, it returns a boolean array, each element of the array represents
        a pass(false) or a fail(true) in that specific category. A failed return in a catagory
        will trigger a warning message within the calling method.
    */    

    public boolean[] verify()
        {
            String[] selector = {"day" , "month" , "year" , "hours" , "mins" , "secs"};
            boolean[] verifCheck = new boolean[2];
            JTextField[] fieldSelector = {day , month , year , hours , mins , secs};
            
        for(int x = 0 ; x <= 5 ; x++)
            {
                try {
                    Integer.parseInt(fieldSelector[x].getText());
                } catch (Exception e) {
                    verifCheck[0] = true;
                    failed.add(selector[x]); //Keeps a count of which variables (day, month , year, etc.) failed the vibecheck
                }

                if (name.getText() == "")
                    {
                        verifCheck[1] = true;
                    }
            }

            return verifCheck;

        }

} // TrainingRecordGUI

