package adapter.animals;

/**
 * This class constructs a few objects and places them in a cage.
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class AdapterDriver {

    /**
     * @param args main method that tests if a stuffed bear can be placed in a cage
     */
    public static void main(String[] args) {
        Cage cage = new Cage();
        Bear bear = new Bear(5, "Black Bear");
        StuffedBear stuffedBear = new StuffedBear("Plastic");
        SBAdapter toyBear = new SBAdapter("Toy Bear", 3, stuffedBear);
        SBAdapter stuffed = new SBAdapter("Plush Bear", 2, new StuffedBear("Plush"));

        cage.addToCage(bear);
        cage.addToCage(toyBear);
        cage.addToCage(stuffed);
        cage.emptyCage();
    }
}
