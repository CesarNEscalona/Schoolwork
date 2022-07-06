package car_dodgers.game_mechanics;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
    private static final int SHMIXEL_CORRECTION = 150;

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
    }

    private void setupControls()
    {
        screen.addComponentToScreen(playerCar);
        screen.addKeyListenerToScreen(this);
    }

    @Override
    public void keyTyped(KeyEvent pressedKey)
    {
        // not being used
    }

    @Override
    public void keyPressed(KeyEvent pressedKey)
    {
        if (pressedKey.getKeyCode() == UP_KEY &&
                (playerCar.getY() > 0)) {
            playerCar.setLocation(playerCar.getX(), playerCar.getY()- PLAYER_CAR_SPEED);
        }
        else if (pressedKey.getKeyCode() == DOWN_KEY &&
                (playerCar.getY() < (screen.getHeight() - SHMIXEL_CORRECTION))) {
            playerCar.setLocation(playerCar.getX(), playerCar.getY()+ PLAYER_CAR_SPEED);
        }
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
