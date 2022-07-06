package strategy.interfaces;

/**
 * This interface will work with all the sort algorithms as a blueprint of methods
 *
 * @param <T> the generic type that is passed in
 * @author Cesar Escalona
 * @version 1.0
 */
public interface ISorts<T> {
    /**
     * @param array takes in an array
     */
    public void sort(T[] array);
}
