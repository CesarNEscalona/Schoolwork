package strategy.interfaces;

/**
 * This interface will work with all the search algorithms as a blueprint of methods
 *
 * @param <T> the generic type
 * @author Cesar Escalona
 * @version 1.0
 */
public interface ISearch<T> {
    /**
     * @param array takes in an array
     * @return returns the generic type if found
     */
    public T find(T[] array);
}
