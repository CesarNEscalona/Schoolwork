package car_dodgers.game_mechanics;

import car_dodgers.flyweight.IRockType;
import car_dodgers.flyweight.IndividualRock;
import car_dodgers.flyweight.RockFactory;
import car_dodgers.flyweight.RockSmall;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * src/car_dodgers/game_mechanics/PlayerControls.java
 *
 * 05/17/2022
 * @author Cesar Escalona, David Boone, Phillip Ball
 * @version 1
 *
 * This class adds controls to a given JLabel PlayerCar on a given JFrame Screen.
 */
public class PlayerControls extends JFrame implements KeyListener
{
    private Screen screen;
    private JLabel playerCar;
    private static final int UP_KEY = 38;
    private static final int DOWN_KEY = 40;
    private static final int PLAYER_CAR_SPEED = 20;
    private static final int NUMBER_OF_ROCKS = 500;
    private static final int UP_TO_SPACE_BETWEEN_ROCKS = 10000;
    private static final double SHMIXEL_CORRECTION = 1.975;

    /**
     * Adds player control to a PlayerCar on a Screen.
     *
     * @param screen the screen of the game
     * @param playerCar the player controlled car
     */
    public PlayerControls(Screen screen, JLabel playerCar)
    {
        this.screen = screen;
        this.playerCar = playerCar;

        setupControls();
        spawnSmallRocks();
    }

    private void setupControls()
    {
        screen.addComponentToScreen(playerCar);
        screen.addKeyListenerToScreen(this);
    }

    private void spawnSmallRocks()
    {
        Random random = new Random();

        // initialize variables that receive data in the for loop
        IRockType rockType;
        IndividualRock rock;
        int spawnPointX;
        int spawnPointY;

        for (int i = 0; i < NUMBER_OF_ROCKS; i++) {
            // set up a spawn point for a rock
            spawnPointX = screen.getWidth() + random.nextInt(UP_TO_SPACE_BETWEEN_ROCKS);
            spawnPointY = random.nextInt(screen.getHeight());

            // add the IRockType to the flyweight
            rockType = RockFactory.getRockType(
                    "RockSmall",
                    new RockSmall(),
                    spawnPointX,
                    spawnPointY);

            // make a new rock using the flyweight
            rock = new IndividualRock(rockType, spawnPointX, spawnPointY);

            // put the new rock on the screen
            rock.spawn(
                    screen,
                    spawnPointX,
                    spawnPointY,
                    new JLabel()
            );
        }
    }

    @Override
    public void keyPressed(KeyEvent pressedKey)
    {
        if (pressedKey.getKeyCode() == UP_KEY &&
                (playerCar.getY() > 0)) {
            playerCar.setLocation(playerCar.getX(), playerCar.getY()- PLAYER_CAR_SPEED);
        }
        else if (pressedKey.getKeyCode() == DOWN_KEY &&
                (playerCar.getY() < (screen.getHeight() - (playerCar.getHeight() * SHMIXEL_CORRECTION)))) {
            playerCar.setLocation(playerCar.getX(), playerCar.getY()+ PLAYER_CAR_SPEED);
        }
    }

    @Override
    public void keyTyped(KeyEvent pressedKey)
    {
        // not being used
    }

    @Override
    public void keyReleased(KeyEvent pressedKey)
    {
        // not being used
    }

    @Override
    public String toString()
    {
        return "This method was added to appease the linter gods.";
    }
}
