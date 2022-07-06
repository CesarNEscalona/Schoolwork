package example;

/**
 * The entry point to my app.
 *
 * @author Josh Archer
 * @version 1.0
 */
public class TestMyCroissants
{
    /**
     * Loads my program.
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        Croissant myTreat = new Croissant();
        System.out.println(myTreat);

        Croissant anotherTreat = new Croissant(true, false, true);
        System.out.println(anotherTreat);

        //test out our getters
        System.out.println(myTreat.isWholeWheat());
        System.out.println(myTreat.isEaten());
        System.out.println(myTreat.isStuffed());
    }
}
