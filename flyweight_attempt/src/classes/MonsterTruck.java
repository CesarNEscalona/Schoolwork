package classes;

import common_shared.SharedClass;
import interfaces.ICar;

public class MonsterTruck implements ICar {
    private String type = "Monster Truck";

    @Override
    public void setBrand(String type) {
        this.type = type;
    }

    @Override
    public void printCarAttributes() {
        System.out.println("This vehicle's brand is " + type + " and it's a " + type);
        System.out.println("This " + type + " has " + SharedClass.wheels + " wheels.");
    }
}
