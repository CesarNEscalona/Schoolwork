package tests;

import baby_names.BabyNames;
import baby_names.FileIO;
import bst.BabyNamesTree;
import java.util.List;

/**
 * The goal of this class is to manually test my methods, this way I can
 * find errors within code and know where the issue lies
 */


public class myTest {
    public static void main(String[] args) {
        BabyNamesTree test = new BabyNamesTree();
        test.add(new BabyNames("Wa", "Male", 2010, "Cesar", 5));
        test.add(new BabyNames("Wa", "Male", 2010, "Nate", 12));
        System.out.println((test.size()));
        //test.clear();
        List<BabyNames> list = FileIO.read("alabama", 2010);;
        test.add(list.get(1));
        System.out.println("Test: " + test.size());
        System.out.println(test.contains(list.get(2)));
        System.out.println(list.get(1).getName());
        System.out.println(test.treeHeight());
    }
}
