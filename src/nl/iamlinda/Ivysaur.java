package nl.iamlinda;

public class Ivysaur extends Bulbasaur {
    public Ivysaur(String species) {
        super(species);
    }

    @Override
    public void vineWhip() {
        System.out.println(species + " attacks with a DOUBLE Vine Whip");
    }

    public void razorLeaf() {
        System.out.println(species + " attacks with Razor Leaf!");
    }
}
