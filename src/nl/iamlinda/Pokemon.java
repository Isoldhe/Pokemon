package nl.iamlinda;

public class Pokemon {
    String species;

    public Pokemon(String soort) {
        this.species = soort;
    }

    void attack() {
        System.out.println(species + " attacks!");
    }
}
