package car_dodgers.game_mechanics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

/**
 * src/car_dodgers/game_mechanics/Screen.java
 *
 * 05/17/2022
 * @author Cesar Escalona, David Boone, Phillip Ball
 * @version 1
 *
 * This class has methods related to building a JFrame screen.
 */
public class Screen extends JFrame
{
    private static final int SCREEN_WIDTH = 1000;
    private static final int SCREEN_HEIGHT = 499;
    private static final String SCREEN_ICON_IMAGE = "src/car_dodgers/images/IconImage.png";
    private static final Color BACKGROUND_COLOR = Color.WHITE;

    /**
     * Builds the screen.
     *
     * @return the screen that was built
     */
    public Screen buildScreen()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
        this.setLayout(null);
        this.setIconImage(new ImageIcon(SCREEN_ICON_IMAGE).getImage());
        this.getContentPane().setBackground(BACKGROUND_COLOR);
        this.setVisible(true);
        return this;
    }

    /**
     * Adds a component to the screen.
     *
     * @param component a JLabel Object
     */
    public void addComponentToScreen(JLabel component)
    {
        this.add(component);
    }

    /**
     * Adds a KeyListener to the screen.
     *
     * @param keyListener a KeyListener Object
     */
    public void addKeyListenerToScreen(KeyListener keyListener)
    {
        this.addKeyListener(keyListener);
    }
}
