package strategy.find_smallest_type;

import strategy.interfaces.ISearch;

/**
 * This class will find the smallest type of generic it's looking for
 *
 * @param <T> the generic type that is passed in
 * @author Cesar Escalona
 * @version 1.0
 */
public class FindSmallestType<T extends Comparable<T>> implements ISearch<T> {

    @Override
    public T find(T[] array) {
        return array[0];
    }
}
