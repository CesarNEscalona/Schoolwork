package flyweight;

import classes.MonsterTruck;
import classes.RallyCar;
import interfaces.ICar;
import java.util.HashMap;

public class FlyweightFactory {

    private static final HashMap<String, ICar> carMap = new HashMap<>();

    public static ICar getRallyCar(String type){
        String key = type + " - Car";

        ICar car = carMap.get(key);

        if(car != null){
            return car;
        } else {
            car = new RallyCar();
            car.setBrand(type);
            carMap.put(key, car);
        }
        return car;
    }

    public static ICar getMonsterTruck(String type){
        String key = type + " - Monster Truck";

        ICar truck = carMap.get(key);

        if(truck != null){
            return truck;
        } else {
            truck = new MonsterTruck();
            truck.setBrand(type);
            carMap.put(key, truck);
        }
        return truck;
    }
}
