package copyconstructors;

public class Car {
    private String make;
    private String model;
    private Engine engine;

    public Car(String make, String model, Engine engine) {
        this.make = make;
        this.model = model;
        this.engine = engine; // shallow copy
    }

    // deep copy constructor
    public Car(Car other){
        this.make = other.make; // immutable - Strings are unchangable once constructed
        this.model = other.model;  // immutable
        this.engine = new Engine(other.engine);  // provide a deep copy constructor for the engine class
    }


    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return "Car [make=" + make + ", model=" + model + ", engine=" + engine
                + "]";
    }
}
