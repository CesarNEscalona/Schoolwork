package classes;

import common_shared.SharedClass;
import interfaces.ICar;

public class RallyCar implements ICar {
    private String type = "Subaru";


    @Override
    public void setBrand(String type) {
        this.type = type;
    }

    @Override
    public void printCarAttributes() {
        System.out.println("This vehicle's brand is " + type);
        System.out.println("This " + type + " has " + SharedClass.wheels + " wheels.");
        System.out.println("This " + type + " has " + SharedClass.battery + " battery.");
        System.out.println("This " + type + " has " + SharedClass.engine + " engine.");
        System.out.println("This " + type + " has " + SharedClass.headLights + " headlights.");
    }
}
