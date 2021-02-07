// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.util.Spliterators.AbstractDoubleSpliterator;

import javax.swing.*;
import java.lang.Number;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    DateFormat format = new SimpleDateFormat("dd/mm/yyyy");

    private JTextField name = new JTextField(30);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JFormattedTextField date = new JFormattedTextField(format);
    private JLabel type = new JLabel("Type:");
    private JLabel labn = new JLabel("Name:");
    private JLabel labDate = new JLabel("Date (DD/MM/YYYY):");
    private JLabel labTime = new JLabel("Time:");
    private JLabel labh = new JLabel(" H:");
    private JLabel labmm = new JLabel(" M:");
    private JLabel labs = new JLabel(" S:");
    private JLabel labWarning = new JLabel("More than one record on this date. Showing most recent entry.");
    private JLabel labdist = new JLabel("Distance:");

    //RUN SPECIFIC LABEL DECLARATIONS
    private JLabel labRunAmount = new JLabel("No. of Runs:");
    private JTextField runAmount = new JTextField(5);
    private JLabel labRests = new JLabel("Recovery time (m):");
    private JTextField rests = new JTextField(5);

    //CYCLE SPECIFIC LABEL DECLARATIONS
    private JLabel labTerrain = new JLabel("Terrain: ");
    private JTextField terrain = new JTextField();
    private JLabel labTempo = new JLabel("Tempo: ");
    private JTextField tempo = new JTextField();

    //SWIM SPECIFIC LABEL DECLARATIONS
    private JLabel labIndoorOutdoor = new JLabel("Location (Indoor/outdoor etc):");
    private JTextField IndoorOutdoor = new JTextField();

    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton findAllByDate = new JButton("Find all");
    private JButton showAll = new JButton("Show me All entries on this date");
    private JComboBox chooseEntry = new JComboBox();
    private JComboBox distanceMod = new JComboBox();
    private JTextArea outputArea = new JTextArea(5, 50);
   //end of GUI declerations
   
    public int setLength = 250; 
    public int dStore;
    public int mStore;
    public int yStore;
    public List<String> failed = new ArrayList<>();
    private TrainingRecord myAthletes = new TrainingRecord();

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    
    public TrainingRecordGUI() {

        JFrame frame = new JFrame("TRAININGGUI");
        setLayout(null);
        setSize(900 , 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        outputArea.setBounds(300 , 10 , 550 , 215);
        add(outputArea);

        //Entry choice drawing
        type.setBounds(5 , 5 , 100 , 20);
        add(type);
        chooseEntry.setBounds(50 , 5 , 100 , 20 );
        chooseEntry.addItem("Run");
        chooseEntry.addItem("Swim");
        chooseEntry.addItem("Cycle");
        chooseEntry.addActionListener(this);
        add(chooseEntry);

        //Name drawing
        name.setBounds(50 , 40 , 200 , 20);
        add(name);
        labn.setBounds(5 , 40 , 100 , 20);
        add(labn);

        //Date drawing
        date.setBounds(120 , 77 , 100 , 20);
        add(date);
        labDate.setBounds(5 , 75 , 110 , 20);
        add(labDate);

        //time drawing
        labTime.setBounds( 5 , 105 , 110 , 20);
        add(labTime);
        labh.setBounds(40 , 105 , 110 , 20);
        add(labh);
        hours.setBounds(60, 105 , 30 , 20);
        add(hours);
        labmm.setBounds(100 , 105 , 30 , 20);
        add(labmm);
        mins.setBounds(120 , 105 , 30 , 20);
        add(mins);
        labs.setBounds(160 , 105 , 30 , 20);
        add(labs);
        secs.setBounds(180 , 105 , 30 ,20);
        add(secs);

        //distance drawing
        labdist.setBounds(5 , 140 , 100 , 20);
        add(labdist);
        dist.setBounds(60 , 140 , 35 , 20);
        add(dist);
        distanceMod.setBounds(100 , 140 , 50 , 19);
        distanceMod.addItem("km");
        distanceMod.addItem("m");
        add(distanceMod);

        //RUN SPECIFIC DRAWING
        labRunAmount.setBounds(5 , 175 , 75 , 20);
        add(labRunAmount);
        runAmount.setBounds(80 , 175 , 50 , 20);
        add(runAmount);

        labRests.setBounds(5 , 210 , 110 , 20);
        add(labRests);
        rests.setBounds(120 , 210 , 110 , 20);
        add(rests);
        //End of run specific drawing

        //CYCLE SPECIFIC DRAWING
        labTerrain.setBounds(5 , 175 , 110 , 20);
        add(labTerrain);
        terrain.setBounds(55 , 175 , 110 , 20);
        add(terrain);

        labTempo.setBounds(5 , 205 , 110 , 20);
        add(labTempo);
        tempo.setBounds(50 , 205 , 110 , 20);
        add(tempo);

        labTerrain.setVisible(false);
        terrain.setVisible(false);
        labTempo.setVisible(false);
        tempo.setVisible(false);
        //End of cycle specific drawing

        //SWIM SPECIFIC DRAWING
        labIndoorOutdoor.setBounds(5 , 175 , 175 , 20);
        add(labIndoorOutdoor);
        IndoorOutdoor.setBounds(180 , 177 , 110 , 20);
        add(IndoorOutdoor);

        labIndoorOutdoor.setVisible(false);
        IndoorOutdoor.setVisible(false);
        //End of swim specific drawing

        //Buttons
         addR.setBounds(5 , 235 , 70 , 20);
         add(addR);
         addR.addActionListener(this);

         lookUpByDate.setBounds(700 , 233 , 80 , 20);
         add(lookUpByDate);
         lookUpByDate.addActionListener(this);

         findAllByDate.setBounds(785 , 233 , 80 , 20);
         add(findAllByDate);
         findAllByDate.addActionListener(this);
         add(showAll);
         showAll.addActionListener(this);

        // add(labWarning);
        // labWarning.setVisible(false);
        // add(outputArea);
        // showAll.setVisible(false);
         outputArea.setEditable(false);

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

        //this one is inneficcient but it works so who cares
        if (event.getSource() == chooseEntry) {

            String choice = chooseEntry.getSelectedItem().toString();

            switch (choice) {
    
                case "Run":
                    changing();
                    labRunAmount.setVisible(true);
                    runAmount.setVisible(true);
                    labRests.setVisible(true);
                    rests.setVisible(true);

                break;
                case "Swim":
                    changing();
                    labIndoorOutdoor.setVisible(true);
                    IndoorOutdoor.setVisible(true);

                break;
                case "Cycle":
                    changing();
                    labTerrain.setVisible(true);
                    terrain.setVisible(true);
                    labTempo.setVisible(true);
                    tempo.setVisible(true);

                break;
            }
        }
        outputArea.setText(message);
       //blankDisplay();
    } // actionPerformed


    /* Adds the user inputted entries to the system. First line is a method call used to
       verify the numbers as integers using try/catch. Throws an exception if they ain't.
    */
    public String addEntry(String what) {

        boolean[] Vercheck = verify();

        //Integer verification      
        
            if(Vercheck[1] == true || Vercheck[0] == true)
                {
        
                if(Vercheck[0] == true)
                 {
                     JOptionPane.showMessageDialog(null , "The field(s) \n" + failed.toString() + " \n must have an integer value." );
                     failed.clear();

                 }
                if(Vercheck[1] == true)
                 {
                     JOptionPane.showMessageDialog(null , "The field 'name' must have a value." );
                 }
                 return null;
                }

        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        String fullDate = date.getText();

        String distnce = dist.getText() + distanceMod.getSelectedItem();
        String[] splitDate = fullDate.split("/");
        int d = Integer.parseInt(splitDate[0]);
        int m = Integer.parseInt(splitDate[1]);
        int y = Integer.parseInt(splitDate[2]);
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        //END OF UNIVERSAL VARIABLES FOR THIS METHOD

        //cycle variables
         String terr;
         String temp;

        //run variables
        int runamnt;
        int resting;

        //swim variables
        String inOut;


                String switcher = chooseEntry.getSelectedItem().toString();
                
                switch(switcher) {

                    case "Cycle":
                        terr = terrain.getText();
                        temp = tempo.getText();
                        CycleEntry cycent = new CycleEntry(n , d , m , y , h , mm , s , distnce , terr , temp);
                        myAthletes.addEntry(cycent);
                    break;

                    case "Run":
                        runamnt = Integer.parseInt(runAmount.getText());
                        resting = Integer.parseInt(rests.getText());
                       myAthletes.addEntry(new sprintEntry(n , d , m , y , h , mm , s , distnce , runamnt , resting));
                    break;

                    case "Swim":
                        inOut = IndoorOutdoor.getText();
                       myAthletes.addEntry(new SwimEntry(n , d , m , y , h , mm , s , distnce , inOut));

                }

        return message;
    }
    

    public String lookupEntry() {
        String fullDate = date.getText();
        String[] splitDate = fullDate.split("/");
        int d = Integer.parseInt(splitDate[0]);
        int m = Integer.parseInt(splitDate[1]);
        int y = Integer.parseInt(splitDate[2]);
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
        
        try {

                String fullDate = date.getText();
            String[] splitDate = fullDate.split("/");
            int d = Integer.parseInt(splitDate[0]);
            int m = Integer.parseInt(splitDate[1]);
            int y = Integer.parseInt(splitDate[2]);
            outputArea.setText("looking up record ...");

            String returner = myAthletes.lookupAll(d , m , y);
            return returner;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null , "please fill in all appropriate date forms");
            return null;
        }
        

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
        date.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");

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

        **!! This code is garbage and does not handle expansion/tinkering well !!**
    */    

    public boolean[] verify()
        {
            String[] selector = {"hours" , "mins" , "secs" , "date"};
            boolean[] verifCheck = new boolean[2];
            JTextField[] fieldSelector = {hours , mins , secs};
            String nameT = "";
            
        for(int x = 0 ; x <= 2 ; x++)
            {
                try {
                    Integer.parseInt(fieldSelector[x].getText());
                } catch (Exception e) {
                    verifCheck[0] = true;
                    failed.add(selector[x]); //Keeps a count of which variables (day, month , year, etc.) failed the vibecheck
                }

            }

            if (name.getText() == nameT)
                    {
                        verifCheck[1] = true;
                    }

                if (date.getText() == "")
                    {
                        verifCheck[0] = true;
                        failed.add(selector[4]);
                    }

            return verifCheck;

        }

        //Handles the visibility of objects during window switching
        private void changing(){

            JLabel[] labChangers = {labRunAmount ,  labRests ,  labTerrain ,  labIndoorOutdoor , labTempo};
            JTextField[] textChangers = {runAmount , rests , terrain , IndoorOutdoor , tempo};

            for(int x = 0 ; x < labChangers.length ; x++)
                {

                   labChangers[x].setVisible(false);
                   textChangers[x].setVisible(false);


                }

        }

} // TrainingRecordGUI

