package Animals;

public class Penguin extends Animal{

    private double bloodPressure;

    public Penguin(){
        super();
        super.setSpecies("Penguin");
        this.setBloodPressure(420);
    }


    public double getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(double bloodPressure){
        this.bloodPressure = bloodPressure;
    }
}
