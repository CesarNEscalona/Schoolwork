package car_dodgers.flyweight;

import car_dodgers.game_mechanics.Screen;

import javax.swing.*;

/**
 * src/car_dodgers/flyweight/IRockType.java
 *
 * 05/26/2022
 * @author Cesar Escalona, David Boone, Phillip Ball
 * @version 1
 *
 * This interface supplies the spawn method used by IndividualRocks and IRockTypes.
 */
public interface IRockType
{
    /**
     *
     * @param screen a Screen object
     * @param spawnPointX the X coordinate of a rock
     * @param spawnPointY the Y coordinate of a rock
     * @param newRock the JLabel of a rock
     */
    void spawn(Screen screen, int spawnPointX, int spawnPointY, JLabel newRock);
}
