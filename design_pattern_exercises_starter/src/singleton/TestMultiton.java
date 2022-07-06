package singleton;

/**
 * This class will test out the multiton pattern
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class TestMultiton {
    /**
     * @param args main method that runs the program
     */
    public static void main(String[] args) {

        Bike first = Bike.getInstance(Bike.BikeType.BMX);
        System.out.println(first);

        Bike second = Bike.getInstance(Bike.BikeType.MOUNTAIN);
        System.out.println(second);

        Bike third = Bike.getInstance(Bike.BikeType.RACE);
        System.out.println(third);
    }
}
