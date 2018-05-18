package nl.iamlinda;

public class Venusaur extends Ivysaur {
    public Venusaur(String species) {
        super(species);
    }

    public void powerWhip() {
        System.out.println(species + " attacks with Power Whip!");
    }

    // A child class can do anything its parent can
    // Venusaur is a child of Ivysaur, who is a child of Bulbasaur, who implements Catchable
    // Therefore, both Ivysaur and Venusaur are Catchable as well,
    // but you don't have to implicitly include Catchable's abstract method(s) in them, because Bulbasaur already does this job
}
