package Animals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class MainFrame implements ActionListener{
    private int y = 20; // used for the entry label so that it doesn't get overwritten in the function.

    private int currentAnimal = 0;//used for animal arraylist

    private boolean gpsAdded;


    private boolean penguin;
    private boolean seaLion;
    private boolean walrus;

    private JFrame main;
    private ArrayList<Animal> animals = new ArrayList<Animal>();

    private JPanel mainPanel;
    private JPanel reportPanel;

    //Gui labels
    private JLabel observedLabel;
    private JLabel animalLabel;
    private JLabel genderLabel;
    private JLabel weightLabel;
    private JLabel pressureLabel;
    private JLabel guideLabel;
    private JLabel reportLabel;
    private JLabel dentalLabel;
    private JLabel spotsLabel;

    //GUI text input fields
    private JTextField weightInput;
    private JTextField variableInput;
    private JTextField gpsInput;

    //GUI Gps display
    private JTextArea gpsDisplay;
    private JTextArea reportDisplay;

    private JScrollPane reportScroll;

    //GUI Drop bars
    private JComboBox animalDrop;
    private JComboBox genderDrop;
    private JComboBox dentalDrop;

    //GUI buttons
    private JButton animalEntryButton;
    private JButton addGpsButton;

    private JButton showEntries;
    private JButton showGps;
    private JButton backButton;
    private JButton reportButton;


    //fonts / colors
    private final Font basicFont = new Font("Sans-serif", Font.BOLD, 13);
    private final Color black = Color.BLACK;

    public MainFrame(){
        mainMenu();
    }


    private void  mainMenu(){

        //animal entry
        observedLabel = createLabel("Animal Observed:");
        animalLabel = createLabel("Animal");
        genderLabel = createLabel("Gender");
        weightLabel = createLabel("Weight in Kg");
        pressureLabel = createLabel("Blood Pressure");

        dentalLabel = new JLabel("Dental health");
        dentalLabel.setBounds(15,150,150,40);
        dentalLabel.setVisible(true);
        dentalLabel.setFont(basicFont);
        dentalLabel.setForeground(black);
        dentalLabel.setVisible(false);

        spotsLabel = new JLabel("Spots");
        spotsLabel.setBounds(15,150,150,40);
        spotsLabel.setFont(basicFont);
        spotsLabel.setForeground(black);
        spotsLabel.setVisible(false);



        String[] animalList = {"Penguin","Sea Lion","Walrus"};
        animalDrop = new JComboBox(animalList);
        animalDrop.setBounds(130, 60, 80, 20);
        animalDrop.setVisible(true);
        animalDrop.addActionListener(this);

        String[] genderList = {"Female","Male"};
        genderDrop = new JComboBox(genderList);
        genderDrop.setBounds(130, 95, 80, 20);
        genderDrop.setVisible(true);
        genderDrop.addActionListener(this);

        String[] dentalList = {"Poor","Average","Great"};
        dentalDrop = new JComboBox<>(dentalList);
        dentalDrop.setBounds(130,160, 80,20);
        dentalDrop.setVisible(false);
        dentalDrop.addActionListener(this);

        weightInput = new JTextField();
        weightInput.setBounds(130, 130,80,20);
        weightInput.setForeground(black);
        weightInput.setToolTipText("Confirm data with enter.");
        weightInput.setVisible(true);
        weightInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        variableInput = new JTextField();
        variableInput.setBounds(130, 165,80,20);
        variableInput.setForeground(black);
        variableInput.setToolTipText("Confirm data with enter.");
        variableInput.setVisible(true);
        variableInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double pressureResult;
                int spotResult;
                if(penguin){
                    try {
                        pressureResult = Double.parseDouble(variableInput.getText());
                        if (pressureResult < 1){
                            JOptionPane.showMessageDialog(null,"[Blood pressure]: Invalid Input:\nEnter a double greater than 0.");
                        }
                        else {
                            animals.get(currentAnimal).setBloodPressure(pressureResult);
                        }
                    }catch (NumberFormatException exception){
                        JOptionPane.showMessageDialog(null,"[Blood pressure]: Invalid Input:\nEnter a double greater than 0.");
                    }

                }
                else if(seaLion){
                    try {
                        spotResult = Integer.parseInt(variableInput.getText());
                        if(spotResult< 1){
                            JOptionPane.showMessageDialog(null,"[Spots]: Invalid Input:\nEnter a whole number greater than 0.");
                        }
                        else {
                            animals.get(currentAnimal).setSpots(spotResult);
                        }
                    }catch (NumberFormatException exception){
                        JOptionPane.showMessageDialog(null,"[Spots]: Invalid Input:\nEnter a whole number greater than 0.");
                    }
                }
            }
        });

        animalEntryButton = new JButton("Add Entry");
        animalEntryButton.setBounds(65,185, 120, 25);
        animalEntryButton.setForeground(black);
        animalEntryButton.setVisible(true);
        animalEntryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gpsAdded) {
                    validateData();
                }
                else {
                    JOptionPane.showMessageDialog(null,"At least one GPS location must be entered.");
                }

            }
        });

        //gps
        addGpsButton = new JButton("Add GPS");
        addGpsButton.setBounds(570, 40, 100, 29);
        addGpsButton.setVisible(true);
        addGpsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gps = gpsInput.getText();
                if (Pattern.matches("^-?(90|[0-8]?\\d)(.\\d{7})? *-?(180|1[0-7]\\d|\\d?\\d)(.\\d{7})?$", gps) && gpsInput.getText().length() > 18) {
                    animals.get(currentAnimal).setGpsLocation(animals.get(currentAnimal).getGpsLocation() + gps + "\n");
                    gpsAdded = true;
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid GPS format:\n Latitude values range from -90 to 90.\nLongitudes values range from -180 to 180.\nBoth values must have 7 digits after the decimal." +
                            "\nSeparate latitude and longitude values with a semi colon.\n(.)##.####### (-)(##.###).#######");
                }
            }
        });

        guideLabel = createLabel("GPS Coordinates: (-)##.####### (-)(## or ###).#######");
        guideLabel.setBounds(250, 20, 350,20);

        gpsInput = new JTextField();
        gpsInput.setBounds(250, 40,310, 30);
        gpsInput.setVisible(true);

        //gpsDisplay
        gpsDisplay = new JTextArea();
        gpsDisplay.setBounds(250,75,420,130);
        gpsDisplay.setVisible(true);

        //view report button
        reportButton = new JButton("View Reports");
        reportButton.setBounds(520,215, 150, 29);
        reportButton.setVisible(true);
        reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reportPanel();
            }
        });



        //Main menu panel attributes
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0,0,950,400);
        mainPanel.setVisible(true);

        //panel adds
        mainPanel.add(observedLabel);
        mainPanel.add(animalLabel);
        mainPanel.add(genderLabel);
        mainPanel.add(weightLabel);
        mainPanel.add(pressureLabel);
        mainPanel.add(dentalLabel);
        mainPanel.add(spotsLabel);
        mainPanel.add(animalDrop);
        mainPanel.add(genderDrop);
        mainPanel.add(dentalDrop);
        mainPanel.add(weightInput);
        mainPanel.add(variableInput);
        mainPanel.add(gpsInput);
        mainPanel.add(animalEntryButton);
        mainPanel.add(addGpsButton);
        mainPanel.add(reportButton);
        mainPanel.add(guideLabel);//shows the format required to input gps
        mainPanel.add(gpsDisplay);

        //Frame attributes
        main = new JFrame();
        main.setTitle("Antarctic Animal Tracking");
        main.setLayout(null);
        main.setSize(700,300);
        main.setLocationRelativeTo(null);
        main.setVisible(true);
        main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        //main frame adds
        main.add(mainPanel);
    }


    public void actionPerformed(ActionEvent e){
        if(e.getSource()==animalDrop){
            if(animalDrop.getSelectedItem().equals("Penguin")){
                penguin = true;
                seaLion = false;
                walrus = false;

                pressureLabel.setVisible(true);
                spotsLabel.setVisible(false);
                dentalLabel.setVisible(false);
                dentalDrop.setVisible(false);
                variableInput.setVisible(true);

                animals.add(currentAnimal, new  Penguin());
            }
            else if(animalDrop.getSelectedItem().equals("Sea Lion")){
                penguin = false;
                seaLion = true;
                walrus = false;

                pressureLabel.setVisible(false);
                spotsLabel.setVisible(true);
                dentalDrop.setVisible(false);
                dentalLabel.setVisible(false);
                variableInput.setVisible(true);

                animals.add(currentAnimal, new SeaLion());


            }
            else {
                penguin = false;
                seaLion = false;
                walrus = true;

                pressureLabel.setVisible(false);
                spotsLabel.setVisible(false);
                dentalLabel.setVisible(true);
                variableInput.setVisible(false);
                dentalDrop.setVisible(true);

                animals.add(currentAnimal, new Walrus());
            }
            if (animals.get(currentAnimal + 1) != null){
                animals.set(currentAnimal, animals.get(currentAnimal));//Overwrites the current index to allow the user to change the animal they wish to track
                animals.remove(currentAnimal + 1);
            }


        } else if (e.getSource() == genderDrop) {

            if (genderDrop.getSelectedItem().equals("Male")) {
                animals.get(currentAnimal).setGender("Male");

            }
            else {
                animals.get(currentAnimal).setGender("Female");
            }
        } else if (e.getSource() == dentalDrop) {

            if(dentalDrop.getSelectedItem() == "Poor"){
                animals.get(currentAnimal).setDentalHealth("Poor");

            } else if (dentalDrop.getSelectedItem() == "Average") {
                animals.get(currentAnimal).setDentalHealth("Average");
            }
            else {
                animals.get(currentAnimal).setDentalHealth("Great");
            }
        }


    }

    private void reportPanel(){


        //report header
        reportLabel = createLabel("Reports");
        reportLabel.setBounds(10,10,150,25);

        //report display
        reportDisplay = new JTextArea();

        //report Scroll
        reportScroll = new JScrollPane(reportDisplay);
        reportScroll.setBounds(8,40,670,180);
        reportScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        reportScroll.setVisible(true);
        reportDisplay.setEditable(false);
        reportScroll.setAutoscrolls(false);

        //show enteries button
        showEntries = new JButton("Show New Entries");
        showEntries.setBounds(125,225,150,27);
        showEntries.setForeground(black);
        showEntries.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateEntries();
            }
        });

        //show gps button
        showGps = new JButton("Show GPS Logs");
        showGps.setBounds(280,225,150,27);
        showGps.setForeground(black);
        showGps.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateGps();
            }
        });

        //back button
        backButton = new JButton("Back");
        backButton.setBounds(435,225,150,27);
        backButton.setForeground(black);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reportPanel.setVisible(false);
                mainPanel.setVisible(true);
            }
        });



        //report panel attributes
        reportPanel = new JPanel();
        reportPanel.setLayout(null);
        reportPanel.setBounds(0,0,700,300);

        //report panel adds
        reportPanel.add(reportLabel);
        reportPanel.add(reportScroll);
        reportPanel.add(showEntries);
        reportPanel.add(showGps);
        reportPanel.add(backButton);


        main.add(reportPanel);
        mainPanel.setVisible(false);
        reportPanel.setVisible(true);

    }

    private void generateGps(){
        String report = "";
        for (int i = 0; i<animals.size(); i++){
            report += animals.get(i).getGpsLocation();
        }
        reportDisplay.setText(report);
    }

    private void generateEntries(){
        String report = "";
        for (int i = 0; i < animals.size(); i++) {
            report += "Species: " + animals.get(i).getSpecies() + "\n" +
                      "Gender: "  + animals.get(i).getGender() + "\n" +
                      "Weight: "  + animals.get(i).getWeight() + "\n";

            if(animals.get(i).getSpecies().equals("Penguin")){
                report += "Blood Pressure: " + animals.get(i).getBloodPressure();

            }
            else if(animals.get(i).getSpecies().equals("Sea-lion")){
                report += "Dental health: " + animals.get(i).getSpots();

            }
            else if(animals.get(i).getSpecies().equals("Walrus")){
                report += "Spots: " + animals.get(i).getDentalHealth();

            }
            report += "\nGPS Positions:\n" + animals.get(i).getGpsLocation() + "\n----------------------------------------\n";
        }
        reportDisplay.setText(report);
    }


    private void validateData (){
        double pressureResult;
        int spotResult;
        if(penguin){
            try {
                pressureResult = Double.parseDouble(variableInput.getText());
                if (pressureResult < 1){
                    JOptionPane.showMessageDialog(null,"[Blood pressure]: Invalid Input:\nEnter a double greater than 0.");
                }
                else {
                    animals.get(currentAnimal).setBloodPressure(pressureResult);
                    weightValid();
                }
            }catch (NumberFormatException exception){
                JOptionPane.showMessageDialog(null,"[Blood pressure]: Invalid Input:\nEnter a double greater than 0.");
            }

        }
        else if(seaLion){
            try {
                spotResult = Integer.parseInt(variableInput.getText());
                if(spotResult< 1){
                    JOptionPane.showMessageDialog(null,"[Spots]: Invalid Input:\nEnter a whole number greater than 0.");
                }
                else {
                    animals.get(currentAnimal).setSpots(spotResult);
                    weightValid();
                }
            }catch (NumberFormatException exception){
                JOptionPane.showMessageDialog(null,"[Spots]: Invalid Input:\nEnter a whole number greater than 0.");
            }
        }
        else if (walrus){
            weightValid();
        }
        else{
            System.out.println("oops.");
        }
    }

    private void entrySuccess(){
        weightInput.setText("");
        variableInput.setText("");
        JOptionPane.showMessageDialog(null, animals.get(currentAnimal).getSpecies() + " saved as new entry.");
        gpsDisplay.setText(animals.get(currentAnimal).getGpsLocation());
        currentAnimal++;
        gpsAdded = false;
    }

    private void weightValid(){
        String weightText = weightInput.getText();
        int weight;
        try {
            weight =  Integer.parseInt(weightText);
            if(weight < 1){
                JOptionPane.showMessageDialog(null,"[Weight]: Invalid Input:\nEnter a whole number greater than 0.");
            }
            else {
                animals.get(currentAnimal).setWeight(weight);
                entrySuccess();
            }
        }
        catch (NumberFormatException exception){
            JOptionPane.showMessageDialog(null,"[Weight]: Invalid Input:\nEnter a whole number greater than 0.");
        }
    }
    private JLabel createLabel(String text){ // Makes a label, defaults work for animal entry.
        JLabel label;
        final int X = 15;
        final int WIDTH = 150;
        final int HEIGHT = 25;

        label = new JLabel(text);
        label.setBounds(X,y,WIDTH,HEIGHT);
        label.setFont(basicFont);
        label.setForeground(black);
        label.setVisible(true);
        y += 35; // go ahead 35 pixels per label.


        return label;
    }

}
