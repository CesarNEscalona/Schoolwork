package observers;

import observables.Rocket;

public class Bystander implements IObserver{

    private String name;
    private String location;

    public Bystander(String name, String location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public void update() {
        System.out.println("Bystander noticed something...");
    }

    @Override
    public void update(Object... args) {
        Rocket rocket = (Rocket)args[0];
        if(args[1].equals("Takeoff")){
            System.out.println(name + " watched " + rocket.getName() +
                    " launch while sitting in his " + location + " home.");
        }
    }
}
