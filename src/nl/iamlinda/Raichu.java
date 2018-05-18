package nl.iamlinda;

public class Raichu extends Pikachu implements Catchable {
    String color = "Orange";

    public Raichu(String species) {
        super(species);
    }

    @Override
    void thunderShock() {
        System.out.println("Raaaai-CHUUUUU!!!");
    }

    // Overloaded method
    void thunderShock(String s) {
        System.out.println("Raaaaai-CHUUUUU " + s);
    }

    public void catchPokemon() {
        System.out.println("You caught " + species);
    }

    Pikachu breed() {
        return new Pikachu("Pika");
    }
}
