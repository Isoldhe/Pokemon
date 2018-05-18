package nl.iamlinda;

public class Pikachu extends Pokemon {
    String color = "Yellow";

    public Pikachu(String species) {
        super(species);
    }

    void thunderShock() {
        System.out.println("Pikaaaa-CHUUUU!!!");
    }
}
