package car_dodgers.game_mechanics;

import javax.swing.*;

/**
 * src/car_dodgers/game_mechanics/PlayerCar.java
 *
 * 05/17/2022
 * @author Cesar Escalona, David Boone, Phillip Ball
 * @version 1
 *
 * This class has methods related to building a JLabel car for a player.
 */
public class PlayerCar extends JFrame
{
    private static final int PLAYER_CAR_WIDTH = 200;
    private static final int PLAYER_CAR_HEIGHT = 100;
    private static final String PLAYER_CAR_IMAGE = "src/car_dodgers/images/TestCarImage.png";

    /**
     * Builds the car.
     *
     * @return the car that was built
     */
    public JLabel buildCar()
    {
        JLabel playerCar = new JLabel();
        playerCar.setIcon(new ImageIcon(PLAYER_CAR_IMAGE));
        playerCar.setBounds(0,0,PLAYER_CAR_WIDTH,PLAYER_CAR_HEIGHT);
        return playerCar;
    }
}
