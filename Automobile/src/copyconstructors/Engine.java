package copyconstructors;

import java.util.*;

public class Engine {

    private String type;
    private List<Part> parts;
    private boolean broken = false;

    public Engine(String type, List<Part> parts) {

        this.type = type;
        this.parts = parts; // shallow copy
    }

    // deep copy constructor
    public Engine(Engine other) {
        this.type = other.type;
        this.parts = new ArrayList<>();  // size 0
        // traverse other.parts and add each part to this.parts
        for (Part p : other.parts){
            this.parts.add(new Part(p));  // it is not okay to use this.parts.add(p); shallow copy of part
        }
    }

    public String getType() {
        return type;
    }

    public void breakEngine() {
        broken = true;
    }

    public void fixEngine() {
        broken = false;
    }

    public List<Part> getParts() {
        return parts;
    }

    @Override
    public String toString() {
        return "Engine [type=" + type + ", parts=" + parts
                + ", broken=" + broken + "]";
    }
}
