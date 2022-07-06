package athletes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SportsNews {

    private List<IAthlete> athletes;

    public SportsNews() {
        athletes = new ArrayList<>();
    }

    public void trackAthlete(IAthlete athlete){
        athletes.add(athlete);
    }

    public void printStats(){
        for (IAthlete athlete:
             athletes) {
            System.out.println("Athlete: " + athlete.getFullName());
            System.out.println("*******************");
            Arrays.stream(athlete.getStats()).forEach(System.out::println);
            System.out.println("*******************");
            System.out.println();
        }
    }
}
