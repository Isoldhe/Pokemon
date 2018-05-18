package nl.iamlinda;

public interface Catchable {
    // abstract methods don't have a body and HAVE to be implemented by classes that implement the interface
    void catchPokemon();

    // default methods in interfaces do have bodies and can be called by classes that implement the interface
    default void run() {
        System.out.println("The pokemon got away!");
    }

    // static methods belong to the interface, so you can only call it from the interface class:
    // Catchable.hide();
    static void hide() {
        System.out.println("The pokemon is hiding in a static environment");
    }
}
