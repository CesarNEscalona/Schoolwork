package tests;


import java.util.ArrayList;
import java.util.List;

public class Tests {

    public static void main(String[] args) {

        // create a list of words
        List words = new ArrayList();
        words.add("penumbra");
        words.add("penultimate");

//print the first letter of the first word
        String firstLetter = words.get(0).toString().substring(0, 1);
        System.out.println(firstLetter);


    }
    }
