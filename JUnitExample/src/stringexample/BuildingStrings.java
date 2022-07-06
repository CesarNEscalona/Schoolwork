package stringexample;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.LinkedTransferQueue;

public class BuildingStrings {

    public static void main(String[] args) {

        ArrayList<Color> list = new ArrayList<>();
        Random ran = new Random();
        for (int i = 0; i < 50; i++){
            list.add(new Color(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256)));
        }
        ColorList myList = new ColorList(list);
        System.out.println(myList);
    }
}
