package singleton;

public class Bike {
    private String model;
    private String type;
    private boolean kickStand;

    //singleton pattern being applied
    private static Bike instance;

    private Bike(String model, String type, boolean kickStand) {
        this.model = model;
        this.type = type;
        this.kickStand = kickStand;
    }

    // Access my singleton here...
    public static Bike getInstance(){
        // lazy-initialization pattern - instead of creating it on line 9, we create
        // it here once the getInstance method is called
        if(instance == null){
            instance = new Bike("Brand", "Mountain", true);
        }

        return instance;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setKickStand(boolean kickStand) {
        this.kickStand = kickStand;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public boolean isKickStand() {
        return kickStand;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", kickStand=" + kickStand +
                '}';
    }
}
