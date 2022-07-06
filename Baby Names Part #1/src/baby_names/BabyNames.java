package baby_names;

/**
 * Represents a name chosen for babies in a certain state and year.
 *
 * @author Josh Archer
 * @version 1.0
 */
public class BabyNames implements Comparable<BabyNames>
{
    private String state;
    private String gender;
    private int year;
    private String name;
    private int frequency;

    /**
     * Creates a new BabyNames object.
     *
     * @param state the state the babies were named in
     * @param gender the gender of the babies
     * @param year the year the babies were named
     * @param name the name chosen for the babies
     * @param frequency the number of times the name was chosen
     */
    public BabyNames(String state, String gender, int year, String name, int frequency)
    {
        this.state = state;
        this.gender = gender;
        this.year = year;
        this.name = name;
        this.frequency = frequency;
    }

    /**
     * Compares two BabyNames objects based on their names.
     *
     * @param other the other BabyNames object
     * @return an integer ordering BabyNames objects in ascending order using
     *         the lexicographic ordering of their names
     */
    @Override
    public int compareTo(BabyNames other)
    {
        // return name compared to other name
        return name.compareTo(other.name);
    }

    /**
     * Returns the state the baby was named in
     * @return a US state
     */
    public String getState()
    {
        return state;
    }

    /**
     * Returns the gender of the babies that were named.
     * @return a gender
     */
    public String getGender()
    {
        return gender;
    }

    /**
     * Returns the year the babies were named.
     * @return a year
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Returns the name chosen for the babies.
     * @return the name of the babies
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the number of times the name was chosen.
     * @return the frequency of the name
     */
    public int getFrequency()
    {
        return frequency;
    }

    @Override
    public String toString()
    {
        return name + "(" + year + ") - " + frequency + " times";
    }
}
