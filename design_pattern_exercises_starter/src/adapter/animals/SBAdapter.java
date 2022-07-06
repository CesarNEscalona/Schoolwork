package adapter.animals;

/**
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class SBAdapter extends Animal{
    private StuffedBear bear;


    /**
     * @param type the type of stuffed bear it is
     * @param avgLifeSpan the average life span for the stuffed bear
     * @param bear the stuffed bear itself
     */
    public SBAdapter(String type, int avgLifeSpan, StuffedBear bear) {
        super(type, avgLifeSpan);
        this.bear = bear;
    }

    /**
     * @return returns the stuffed bear
     */
    public StuffedBear getBear() {
        return bear;
    }

    @Override
    public String toString() {
        return "SBAdapter{" +
                "bear=" + bear +
                '}';
    }
}
