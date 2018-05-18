package nl.iamlinda;

public class Bulbasaur extends Pokemon implements Catchable {
    public Bulbasaur(String species) {
        super(species);
    }

    public void vineWhip() {
        System.out.println(species + " attacks with Vine Whip");
    }

    // Catchable abstract method implementation
    // Classes that implement an interface are obligated to implement its abstract methods OR you have to declare the class abstract
    public void catchPokemon() {
        System.out.println("You caught " + species);
    }
}
