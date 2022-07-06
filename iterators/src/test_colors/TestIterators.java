package test_colors;

import colors.RgbColor;

public class TestIterators {
    public static void main(String[] args) {
        RgbColor magenta = new RgbColor(255, 0, 255);
        for (int component : magenta){
            System.out.println("Component " + component);
        }
    }
}
