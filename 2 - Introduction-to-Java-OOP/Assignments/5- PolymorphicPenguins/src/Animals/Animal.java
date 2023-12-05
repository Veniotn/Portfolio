package Animals;

import java.util.ArrayList;

abstract class Animal extends Species{
    private String name;
    private String gpsLocation;
    private String gender;
    private int weight;


    public Animal(){
        super();
        this.setName("Make sure to press enter to confirm data");
        this.setGpsLocation("");
        this.setGender("Make sure to press enter to confirm data");
        this.setWeight(0);
    }





    public String getSpecies(){
        return super.getSpecies();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGpsLocation() {
        return this.gpsLocation;
    }

    public void setGpsLocation(String gpsLocation) {
        this.gpsLocation = gpsLocation;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getBloodPressure(){
        return this.getBloodPressure();
    }
    public void setBloodPressure(double pressure){
        this.setBloodPressure(pressure);
    }

    public void setDentalHealth(String health){
        this.setDentalHealth(health);
    }

    public String getDentalHealth(){
        return this.getDentalHealth();
    }

    public void setSpots(int spots){
        this.setSpots(spots);
    }

    public int getSpots(){
        return this.getSpots();
    }
}
