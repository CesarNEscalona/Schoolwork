package stringexample;

import java.awt.*;
import java.util.ArrayList;

public class ColorList {

    private ArrayList<Color> colors;

    public ColorList(ArrayList<Color> c) {
        colors = c;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Color c : colors) {
            result.append(c.toString() + "\n");
        }
        return result.toString();
    }
}
