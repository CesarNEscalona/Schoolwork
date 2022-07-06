package driver;

import flyweight.FlyweightFactory;
import interfaces.ICar;

public class TestClient {
    public static void main(String[] args) {
        ICar impreza = FlyweightFactory.getRallyCar("Subaru");
        System.out.println("This model is an Impreza");
        impreza.printCarAttributes();
        System.out.println(impreza);
        System.out.println();

        ICar outback = FlyweightFactory.getRallyCar("Subaru");
        System.out.println("This model is an Outback");
        outback.printCarAttributes();
        System.out.println(outback);
        System.out.println();

//        ICar monster = FlyweightFactory.getMonsterTruck("Chevy", "Monster Truck");
//        monster.printCarAttributes();
//        System.out.println();
    }
}
