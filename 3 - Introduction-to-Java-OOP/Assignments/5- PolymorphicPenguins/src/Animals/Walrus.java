package Animals;

public class Walrus extends Animal{

    private String dentalHealth;

    public Walrus(){
        super();
        this.setSpecies("Walrus");
    }

    @Override
    public String getDentalHealth() {
        return dentalHealth;
    }

    @Override
    public void setDentalHealth(String dentalHealth) {
        this.dentalHealth = dentalHealth;
    }
}
