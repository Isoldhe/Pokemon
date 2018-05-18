package nl.iamlinda;

/*
* Dit programma is om inheritance/ polymorph te oefenen.
* In Main class staat alles wat ik zelf heb uitgeprobeerd met uitleg erbij (in English)
* Maak vooral je eigen creaties/ combinatie van parent-child relaties, method overriding, overloading en interfaces
* en probeer alles uit tot je weet wat er precies wel en niet mogelijk is met inheritance en interfaces.
* Soms staan er lege System.out.println(); in. Dat is om de output van de console een beetje leesbaar te houden.
*
* Dit zijn de parent - child relaties:
*              Pokemon
*              |      |
*         Pikachu    Bulbasaur
*              |      |
*          Raichu    Ivysaur
*                     |
*                    Venusaur
*
* Catchable is een interface. Alleen Raichu en Bulbasaur implementeren Catchable.
*
* Good luck!
*/

public class Main {
    public static void main(String[] args) {
        Pikachu pika = new Pikachu("Pikachu");
        Raichu raichu = new Raichu("Raichu");
        pika.attack();  // Pikachu attacks!
        pika.thunderShock();  // Pikaaaa-CHUUUU!!!
        raichu.attack();  // Raichu attacks!
        raichu.thunderShock();  // Raaaai-CHUUUUU!!!


        System.out.println();
        System.out.println("Changing furs:");
        /*
          Let's say Pikachu's fur (color) is always yellow, so this is declared as final in his class
          Raichu's fur isn't final, because it's orange in summer and brown in winter (hypothetically)
          If we set raichu's color to "Brown"...
        */
        raichu.color = "Brown";
        // What will this print?
        System.out.println("raichu's color is " + raichu.color);
        // Now if we cast raichu to Pikachu, what will it print?
        System.out.println("raichu's color is after casting to Pikachu is " + ( (Pikachu) raichu ).color);
        /* Answers:
         - raichu.color will print "Brown" (from the Raichu class)
         - (Pikachu) raichu ).color will print "Yellow", taking the final variable color from the Pikachu class
         This is because Java will always look for the fields at the LEFT side of the expression.
         So Raichu raichu = new Raichu();  looks at the String color of Raichu, which we set to "Brown"
         Then we cast raichu to Pikachu, basically saying 'Raichu is now a Pikachu', just like this: Pikachu piiiika = raichu;
         So now it takes the String color variable of Pikachu, which is "Yellow"
        */


        System.out.println();
        // What does the above mean for the methods being called?
        Pikachu piiiika = raichu;
        System.out.println("piiiika's color is " + piiiika.color); // Yellow
        piiiika.thunderShock(); // Raaaai-CHUUUUU!!!
        /*
           piiiika is a Pikachu, so will use the fields of Pikachu class, but the initialisation is a Raichu.
           Java will use the methods of the most specific class, in this case Raichu, because it's a child of Pikachu.
           One condition however is that Raichu needs to override the methods from Pikachu in order to be used like this
           If thunderShock had not been overridden in the Raichu class, piiiika would execute its own thunderShock()
           and the outcome would have been Pikaaaa-CHUUUU!!!
        */

        Pokemon pokePika = new Pikachu("PokePika");
        System.out.println("pokePika's species = " + pokePika.species);  // Pokemon species = PokePika
        pokePika.attack(); // PokePika attacks!
        System.out.println();
        // This is impossible:
        // pokemon.thunderShock();  // Compiler says: can't resolve method thunderShock();
        /*
           Why isn't the above line possible?
           The above is not possible. The object has been initialized like this:
           Pokemon pokemon = new Pikachu("PokePika");
           Rule nr 1: It will always get the variables of the left side of the expression (Pokemon pokemon)
           Rule nr 2: It will try to execute the methods of the most specific class or the right side (Pikachu)
           BUT, you can only do that if the child (Pikachu) overrides the methods from its parent (Pokemon)
           Pikachu can do thunderShock(), but it's not an override of a Pokemon method.
           Pokemon doesn't know who its children are, so it can't execute their methods either.
        */


        System.out.println("A method can return a new Object, like raichu's breed() method:");
        // raichu's breed() returns a new Pikachu named "Pika"
        Pikachu pikapika = raichu.breed();
        pikapika.attack();  // Pika attacks!
        System.out.println();


        System.out.println("Method overrides");
        // The following pikaRai polymorph does know how to do thunderShock(), because Raichu overrides Pikachu's thunderShock():
        Pikachu pikaRai = new Raichu("PikaRai");
        System.out.println(pikaRai.species);  // PikaRai
        pikaRai.thunderShock();  // Raaaai-CHUUUUU!!!
        // It executes the method of the most specific class, in this case Raichu's thunderShock()


        System.out.println();
        System.out.println("PokeRaichu");
        Pokemon pokeRaichu = new Raichu("PokeRaichu");
        pokeRaichu.attack(); // PokeRaichu attacks
        // Again, this interface method, implemented in Raichu won't work, because the Pokemon class doesn't have such a method:
        // pokeRaichu.catchPokemon(); // Compiler says: can't resolve method catchPokemon();

        // You can access objects in another package by using the package name
        // This one is in the same package, so it's redundant, but just for showing how it works:
        nl.iamlinda.Pikachu packagePika = new Pikachu("PackagePika");


        System.out.println();
        System.out.println("Casting:");
        System.out.println("Casting is telling the compiler that one type is now of another type");
        System.out.println("You're basically telling the compiler that you know what you're doing");
        System.out.println("For example: Casting Bulbasaur to Ivysaur");

        Bulbasaur bulba = new Bulbasaur("Bulba");
        // Ivysaur ivyCast = (Ivysaur) bulba; // The compiler trusts you and won't nag with (Ivysaur) there
        // BUT they are incompatible types. Trying to cast this will result in a ClassCastException (RunTimeException)
        // They are incompatable, because Ivysaur is a child of Bulbasaur, and you can't cast a parent to a child
        // You can do it the other way around:
        Pokemon pokeCast = (Pokemon) bulba; // valid, but the IDE will tell you it's a redundant cast, because bulba is a child of Pokemon


        // INTERFACES
        System.out.println();
        // Rule nr 1: Interfaces can NEVER be instantiated --> with THEMSELVES. This is because interfaces are abstract.
        // So you can't do Catchable catchable = new Catchable(); --> compiler error!
        // But you CAN instantiate it with a class that implements the interface:
        System.out.println("Instantiating Catchable with Raichu");
        Catchable catching = new Raichu("RaiRaichu!"); // Totally fine
        catching.catchPokemon(); // Totally works, we caught RaiRaichu!

        // So this is not valid, because Pikachu doesn't implement Catchable:
        // Catchable catchingPika = new Pikachu("Piiiikachu"); // Compiler says: incompatible types
        // If a parent implements an interface, than all its children automatically implement it as well
        // So the children don't have to implement the interface explicitly
        Catchable catchingChiefVenu = new Venusaur("Chief Venusaur");
        catchingChiefVenu.catchPokemon(); // Works fine, because Bulbasaur implements Catchable and Venusaur is a child of Bulbasaur


        System.out.println();
        System.out.println("Grassy overrides and overloads:");
        Bulbasaur bulbasaur = new Bulbasaur("Bulbasaur");
        Ivysaur ivysaur = new Ivysaur("Ivysaur");
        Venusaur venusaur = new Venusaur("Venusaur");

        venusaur.razorLeaf(); // Venusaur attacks with Razor Leaf!
        bulbasaur.vineWhip(); // Bulbasaur attacks with Vine Whip
        ivysaur.vineWhip(); // Ivysaur attacks with a DOUBLE Vine Whip  --> Ivysaur overrides Bulbasaur's vineWhip()
        venusaur.vineWhip(); // Venusaur attacks with a DOUBLE Vine Whip  --> Child of Ivysaur, so uses Ivysaur's vineWhip()

        System.out.println();
        System.out.println("Grassy default and static interface methods:");
        venusaur.catchPokemon(); // You caught Venusaur
        venusaur.run(); // The pokemon got away!  --> run() is a default method in Cstchable interface
        Catchable.hide(); // The pokemon is hiding in a static environment  --> hide() is static in Catchable, so you can't call it like this:
        // venusaur.hide();  // Compiler says: static method may be invoked on containing interface class only


        // Casting to an interface
        System.out.println();
        System.out.println("Casting to an interface");
        Object o = ivysaur; // Object is the mother of all existing objects, so this is fine

        // But this will not compile:
        // Catchable catcheMe = o;
        // Even though we just told the compiler that o points to an Ivysaur, which is Catchable (Because parent class Bulbasaur implements Catchable)
        // You have to explicitly tell the compiler that you know what you're doing and cast o to the Catchable interface:
        Catchable catcheMe = (Catchable) o; // The compiler will rest its case and this will run
        System.out.println(catcheMe); // prints nl.iamlinda.Ivysaur@1540e19d

        // The above won't work for classes that don't implement the interface, like Pikachu:
        Pikachu pikachu = new Pikachu("Pikachu");
        Object obj = pikachu;
        // The following line won't compile, because Pikachu is not Catchable!
        // Catchable catchPikachu = obj;

        // Now we can fool the compiler in believing that the obj pointing to pikachu is actually Catchable:
        // Catchable catchPikachu = (Catchable) obj;
        // Uncomment the above code. As you can see the compiler trusts you and won't complain
        // But Pikachu is still not Catchable, even if you try to cast it.
        // So at runtime it will throw a ClassCastException.

        // The compiler is gullable when it comes to interfaces, but you won't fool the compiler when trying to cast two incompatible classes:
        Bulbasaur bulb = new Bulbasaur("Bulb");
        // Pikachu pichu = (Pikachu) bulb; // Even though Pikachu and Bulbasaur are both Pokemon, they have nothing to do with each other
        // It's like trying to tell java that a Chicken is a WarShip. Not gonna happen!

        // This is fine...
        bulb = ivysaur;
        // However this is not:
        // bulb = (Catchable) ivysaur;
        // Because a bulb is-not-a Catchable, even though Bulbasaur implements Catchable.
        // This is the concept of " is-a relationships "
        // Ivysaur is-a Bulbasaur
        // Bulbasaur is-a Catchable
        // But Catchable is-not-a Bulbasaur
        // It's just like a Bulbasaur is-a Pokemon, but a Pokemon is-not-a Bulbasaur (it could be, but the compiler doesn't know that)
        // BUT:
        bulb = (Bulbasaur) (Catchable) ivysaur;
        // Will compile AND run, because we're telling java explicitly that WE know that ivysaur is-a Catchable and is-a Bulbasaur
        ivysaur = (Ivysaur) (Catchable) bulb;
        // Note that the above line will compile AND run.
        // It won't throw a ClassCastException, because we pointed bulb to ivysaur earlier with correct casts.


        // ClassCastExceptions below:
        Pikachu p = new Pikachu("P");
        Raichu r = new Raichu("R");
        Pokemon po = new Pokemon("Po");
        // p = (Pikachu) po;  // ClassCastException
        // r = (Raichu) p;  // ClassCastException
    }
}