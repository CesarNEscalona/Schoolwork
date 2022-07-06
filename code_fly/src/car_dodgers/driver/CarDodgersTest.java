package car_dodgers.driver;

import car_dodgers.game_mechanics.PlayerCar;
import car_dodgers.game_mechanics.PlayerControls;
import car_dodgers.game_mechanics.Screen;

/**
 * src/car_dodgers/driver/CarDodgersTest.java
 *
 * 05/17/2022
 * @author Cesar Escalona, David Boone, Phillip Ball
 * @version 1
 *
 * This class runs/tests the game.
 */
public class CarDodgersTest
{
    /**
     * Loads the program.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        new PlayerControls(new Screen().buildScreen(), new PlayerCar().buildCar());
    }
}
