package observer.driver;

import observer.observable.Coin;
import observer.observer.CoinFaceListener;
import observer.observer.CoinTypeListener;

/**
 * This class consists of a main method with listeners that do something when a change happens
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class TestObserver {
    /**
     * @param args the main method that creates listeners and prints out when they fire
     */
    public static void main(String[] args) {

        // create observers
        CoinTypeListener bob = new CoinTypeListener("Bob", "Hope");
        CoinFaceListener james = new CoinFaceListener("James", "King");

        // create Observable
        Coin coin = new Coin();

        // attach together
        coin.addChangeListener("coinType", bob);
        coin.addChangeListener("coinsFace", james);

        // make a change and see if observers notice
        coin.setCoinType("Quarter");
        coin.setCoinType("Dime");

        // flip a coin 4 times
        coin.flip();

        coin.flip();

        coin.flip();

        coin.flip();
    }
}
