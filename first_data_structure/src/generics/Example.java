package generics;

import java.util.ArrayList;

public class Example {
    public static void main(String[] args) {
        // upcasting...
        Object name = "Cesar";
        System.out.println(name);

        // dont want to cast, can cause issues
        String nameAsString = (String) name;

        // Raw use error means we forgot the <String>
        ArrayList<String> listOfWords = new ArrayList<>();



    }
}
