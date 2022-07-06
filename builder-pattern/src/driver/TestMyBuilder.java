package driver;

import apparel.Sock;
import apparel.SockBuilder;
import java.awt.*;

public class TestMyBuilder {

    public static void main(String[] args) {

        Sock mySock = new SockBuilder()
                .setColor(Color.WHITE)
                .setSize("Large")
                .price(7.99)
                .ownedAge(2)
                .setMaterial("Cotton")
                .containsHoles(false)
                .paired(true)
                .assemble();

        System.out.println(mySock);

        // is the StringBuilder a Builder?
        String assembled = new StringBuilder()
                .append("hello")
                .append(", ")
                .append("world")
                .toString();

        System.out.println(assembled);
    }
}
