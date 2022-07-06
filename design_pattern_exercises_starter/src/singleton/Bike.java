package singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * This class will feature a multiton class modified from a singleton class
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class Bike {

    private BikeType label;
    // Multiton pattern being applied
    private static Map<BikeType, Bike> instances;

    private Bike(BikeType label){
        this.label = label;
    }

    public enum BikeType{
        BMX, MOUNTAIN, RACE
    }

    /**
     * This method will create an obj when we need it, lazy initialization pattern used
     *
     * @param label takes in a label of type BikeType
     * @return returns a static Bike
     */
    // Access my singleton here...
    public static Bike getInstance(BikeType label){
        // lazy-initialization pattern - instead of creating it on line 9, we create
        // it here once the getInstance method is called, once created it won't enter the if...creating
        // it when we need it
        if(instances == null){
            instances = new HashMap<>();
            Bike instance = new Bike(label);
            instances.put(label, instance);
            return instance;
        }

        Bike instance = new Bike(label);
        instances.put(label, instance);
        return instance;
    }

    /**
     * Getter for a label
     *
     * @return returns the BikeType label
     */
    public BikeType getLabel() {
        return label;
    }

    /**
     * Getter for instances
     *
     * @return returns the map of instances
     */
    public static Map<BikeType, Bike> getInstances() {
        return instances;
    }

    /**
     * Setter for label
     *
     * @param label sets the label to the BikeType label passed in
     */
    public void setLabel(BikeType label) {
        this.label = label;
    }

    /**
     * Setter for instances
     *
     * @param instances sets instances to whatever is passed in
     */
    public static void setInstances(Map<BikeType, Bike> instances) {
        Bike.instances = instances;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "label=" + label +
                '}';
    }
}
