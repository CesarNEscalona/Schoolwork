package athletes;

import java.util.Map;

public class FBAdapter implements IAthlete{

    private FootballAthlete fbAthlete;

    public FBAdapter(FootballAthlete fbAthlete){
        this.fbAthlete = fbAthlete;
    }

    @Override
    public String getFullName() {
        return fbAthlete.getFirst() + " " + fbAthlete.getMiddle() + " " +
                fbAthlete.getLast();
    }

    @Override
    public String[] getStats() {
        Map<String, Object> map = fbAthlete.getStats();
        String[] statArray = new String[map.size()];

        int flag = 0;
        for (String key:
             map.keySet()) {
            statArray[flag++] = key + ": " + map.get(key);
        }
        return statArray;
    }
}
