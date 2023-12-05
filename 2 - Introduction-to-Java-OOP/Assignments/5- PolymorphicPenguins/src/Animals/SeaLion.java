package Animals;

public class SeaLion extends Animal{

    private int spots;

    public SeaLion(){
        super();
        this.setSpecies("Sea-lion");
    }

    public int getSpots() {
        return spots;
    }

    public void setSpots(int spots) {
        this.spots = spots;
    }
}
