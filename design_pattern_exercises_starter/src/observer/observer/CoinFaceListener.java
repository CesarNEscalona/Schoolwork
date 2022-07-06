package observer.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * This class tracks a property change based on the coin face when it is flipped
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class CoinFaceListener implements PropertyChangeListener {
    private String first;
    private String last;

    /**
     * This method creates a listener with a first and last name
     *
     * @param first takes in a first name for a listener
     * @param last takes in a last name for a listener
     */
    public CoinFaceListener(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        boolean newFace = (boolean)evt.getNewValue();

        if(newFace){
            System.out.println("coin flipped heads");
        } else {
            System.out.println("coin flipped tails");
        }
    }

    @Override
    public String toString() {
        return "CoinFaceListener{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }
}
