package athletes;

import java.util.HashMap;
import java.util.Map;


public class FootballAthlete {

    private String first;
    private char middle;
    private String last;
    private Map<String, Object> stats;

    public FootballAthlete(String first, char middle, String last) {
        this.first = first;
        this.middle = middle;
        this.last = last;
        stats = new HashMap<>();
    }

    public void newStat(String name, Object value){
        stats.put(name, value);
    }

    public String getFirst() {
        return first;
    }

    public char getMiddle() {
        return middle;
    }

    public String getLast() {
        return last;
    }

    public Map<String, Object> getStats() {
        return stats;
    }
}
