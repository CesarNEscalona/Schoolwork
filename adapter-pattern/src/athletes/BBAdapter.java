package athletes;

import java.util.List;

public class BBAdapter implements IAthlete{

    private BaseballAthlete athlete;

    public BBAdapter(BaseballAthlete athlete){
        this.athlete = athlete;
    }

    @Override
    public String getFullName() {
        return athlete.getFirstName() + " " + athlete.getLastName();
    }

    @Override
    public String[] getStats() {
        // loop through 2 lists and get the stat name and stat value
        List<String> names = athlete.getStatNames();
        List<Object> values = athlete.getStatValues();
        // create a string array to return with stat or value size
        String[] statsArray = new String[names.size()];

        // iterate through array for stats and values
        for (int i = 0; i < statsArray.length; i++) {
            // get individual string and value and place in array
            statsArray[i] = names.get(i) + ", " + values.get(i);
        }
        return statsArray;
    }
}
