package example;

/**
 * Represents a croissant object.
 *
 * @author Josh Archer
 * @version 1.0
 */
public class Croissant
{
    private boolean wholeWheat;
    private boolean eaten;
    private boolean stuffed;

    /**
     * Creates a new default croissant.
     */
    public Croissant()
    {
        wholeWheat = false;
        eaten = false;
        stuffed = true;
    }

    /**
     * Creates a new croissant with the input values.
     *
     * @param wholeWheat is the croissant whole wheat
     * @param eaten has the croissant been eaten already?
     * @param stuffed is the croissant stuffed or not?
     */
    public Croissant(boolean wholeWheat, boolean eaten, boolean stuffed)
    {
        this.wholeWheat = wholeWheat;
        this.eaten = eaten;
        this.stuffed = stuffed;
    }

    /**
     * Getter for the whole wheat attribute.
     * @return is the croissant whole wheat?
     */
    public boolean isWholeWheat()
    {
        return wholeWheat;
    }

    /**
     * Getter for the eaten attribute.
     * @return is the croissant eaten yet?
     */
    public boolean isEaten()
    {
        return eaten;
    }

    /**
     * Getter for the stuffed attribute.
     * @return is the croissant stuffed
     */
    public boolean isStuffed()
    {
        return stuffed;
    }

    @Override
    public String toString()
    {
        return "Croissant{" +
                "wholeWheat=" + wholeWheat +
                ", eaten=" + eaten +
                ", stuffed=" + stuffed +
                '}';
    }
}