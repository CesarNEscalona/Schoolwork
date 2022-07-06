package factory_methods;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class TestFactoryMethods {
    public static void main(String[] args) {

        // Factory methods in the LocalDate class
        LocalDate date = LocalDate.parse("2021-10-12");
        LocalDate now = LocalDate.now();
        LocalDate yesterday = LocalDate.of(2022, 4, 26);

        // create readonly data structures in Java Collections
        List<String> listOfStrings = List.of("hello", "world", "!");
        Map<String, Integer> readOnlyMap = Map.of(
                "Josh", 45,
                "Tammy", 32
        );

        for (String string: listOfStrings) {
            System.out.println(string);
        }

        // Try out Color methods
        Color cool = Color.blackLight();
        Color random = Color.random();
        Color streamer = Color.magenta();

        System.out.println(cool);
        System.out.println(random);
        System.out.println(streamer);
    }
}
