package car_dodgers.flyweight;

import car_dodgers.game_mechanics.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * src/car_dodgers/flyweight/IndividualRock.java
 *
 * 05/26/2022
 * @author Cesar Escalona, David Boone, Phillip Ball
 * @version 1
 *
 * This class has methods related to a given IRockType.
 * These values are extrinsic when related to the Flyweight pattern.
 */
public class IndividualRock implements ActionListener, IRockType
{
    private static final int MOVEMENT_DISTANCE = 1;
    private int spawnPointX;
    private int spawnPointY;
    private IRockType rockType;
    private JLabel rock;

    /**
     * Constructs an Individual Rock that needs a given IRockType.
     *
     * @param rockType an IRockType
     * @param spawnPointX the x coordinate of the rocks spawn location
     * @param spawnPointY the y coordinate of the rocks spawn location
     */
    public IndividualRock(IRockType rockType, int spawnPointX, int spawnPointY)
    {
        this.rockType = rockType;
        this.spawnPointX = spawnPointX;
        this.spawnPointY = spawnPointY;
    }

    @Override
    public void spawn(Screen screen, int spawnPointX, int spawnPointY, JLabel newRock)
    {
        // spawn the new rock
        rock = newRock;
        rockType.spawn(screen, spawnPointX, spawnPointY, newRock);

        // tell it to move
        Timer animationTimer = new Timer(1, this);
        animationTimer.start();
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        if(spawnPointX >= -rock.getWidth())
        {
            spawnPointX = spawnPointX- MOVEMENT_DISTANCE;
            rock.setLocation(spawnPointX, spawnPointY);
        }
        else
        {
            Container parent = rock.getParent();
            if(parent != null)
            {
                parent.remove(rock);
            }
        }
    }

    @Override
    public String toString()
    {
        return "IndividualRock{" +
                "rockType=" + rockType +
                '}';
    }
}
