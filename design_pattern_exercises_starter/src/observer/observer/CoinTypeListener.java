package observer.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * This class features a listener that tracks a property change based on the coin type
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class CoinTypeListener implements PropertyChangeListener {
    private String name;
    private String last;

    /**
     * This method creates a listener with a first and last name
     *
     * @param name takes in a first name for a coin type listener
     * @param last takes in a last name for a coin type listener
     */
    public CoinTypeListener(String name, String last) {
        this.name = name;
        this.last = last;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getNewValue() != evt.getOldValue()){
            System.out.println("Coin type changed: " + evt.getNewValue());
        }
    }

    @Override
    public String toString() {
        return "CoinTypeListener{" +
                "name='" + name + '\'' +
                ", last='" + last + '\'' +
                '}';
    }
}
