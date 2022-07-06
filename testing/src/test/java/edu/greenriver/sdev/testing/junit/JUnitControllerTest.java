package edu.greenriver.sdev.testing.junit;

import edu.greenriver.sdev.testing.controllers.HomeController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitControllerTest {

    @Test
    public void testHomeController() {
        HomeController homeController = new HomeController();
        String result = homeController.home();
        assertEquals(result, "Hello World!");
    }
}
