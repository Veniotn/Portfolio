package Animals;

abstract class Species {
    private String species;

    public Species(){
        this.species = "";
    }
    public void setSpecies(String species){
        this.species = species;
    }

    public String getSpecies() {
        return species;
    }
}
