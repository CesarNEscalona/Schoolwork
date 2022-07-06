package athletes;

import java.util.ArrayList;
import java.util.List;

public class BaseballAthlete {

    private String firstName;
    private String lastName;
    private List<String> statNames;
    private List<Object> statValues;

    public BaseballAthlete(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        statNames = new ArrayList<>();
        statValues = new ArrayList<>();
    }

    public void addStat(String name, Object value){
        statNames.add(name);
        statValues.add(value);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Object> getStatValues() {
        return statValues;
    }

    public List<String> getStatNames() {
        return statNames;
    }
}
