package car_dodgers.flyweight;

import java.util.HashMap;

/**
 * src/car_dodgers/flyweight/RockFactory.java
 *
 * 05/26/2022
 * @author Cesar Escalona, David Boone, Phillip Ball
 * @version 1
 *
 * This class stores and creates unique IRockTypes using the Flyweight pattern.
 */
public class RockFactory
{
    private static final HashMap<String, IRockType> mapOfRocks = new HashMap<>();

    /**
     * The Factory.
     *
     * @param rockKey a unique key for a given IRockType
     * @param rockType A unique IRockType
     * @param spawnPointX the x coordinate of the rocks spawn location
     * @param spawnPointY the y coordinate of the rocks spawn location
     * @return the IRockType given in the parameters
     */
    public static IRockType getRockType(String rockKey, IRockType rockType, int spawnPointX, int spawnPointY)
    {
        IRockType rock = mapOfRocks.get(rockKey);

        if(rock == null)
        {
            rock = new IndividualRock(rockType, spawnPointX, spawnPointY);
            mapOfRocks.put(rockKey, rock);
            System.out.println("new rock type");
        }

        System.out.println("old rock type");
        return rock;
    }
}
