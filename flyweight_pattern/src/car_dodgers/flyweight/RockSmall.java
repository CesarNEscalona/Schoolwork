package car_dodgers.flyweight;

import car_dodgers.game_mechanics.Screen;

import javax.swing.*;
import java.awt.*;

/**
 * src/car_dodgers/flyweight/RockSmall.java
 *
 * 05/26/2022
 * @author Cesar Escalona, David Boone, Phillip Ball
 * @version 1
 *
 * This class is a unique IRockType.
 * These values are intrinsic when related to the Flyweight pattern.
 */
public class RockSmall implements IRockType
{
    private static final int DIMENSIONS = 10;
    private Image resize = new ImageIcon("src/car_dodgers/images/Rock.png")
            .getImage()
            .getScaledInstance(DIMENSIONS, DIMENSIONS, Image.SCALE_SMOOTH);
    private ImageIcon rockImage = new ImageIcon(resize);

    /**
     * Constructs a RockSmall.
     */
    public RockSmall()
    {
        // empty constructor
    }

    @Override
    public void spawn(Screen screen, int spawnPointX, int spawnPointY, JLabel newRock)
    {
        newRock.setIcon(rockImage);
        newRock.setBounds(spawnPointX, spawnPointY, DIMENSIONS, DIMENSIONS);
        screen.addComponentToScreen(newRock);
    }

    @Override
    public String toString()
    {
        return "This method was added to appease the linter gods.";
    }
}
