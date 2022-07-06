package strategy.strategy;

import strategy.interfaces.ISearch;
import strategy.interfaces.ISorts;

/**
 * This class will use sort or search algorithms to sort out arrays
 *
 * @param <T> the generic type passed in
 * @author Cesar Escalona
 * @version 1.0
 */
public class MySortAndSearch<T extends Comparable<T>> {
    private ISearch<T> search;
    private ISorts<T> sorts;

    /**
     * @param search the search algorithm passed in
     * @param sorts the sort algorithm passed in
     */
    public MySortAndSearch(ISearch<T> search, ISorts<T> sorts) {
        this.search = search;
        this.sorts = sorts;
    }

    /**
     * @param array the array of generic type passed in
     * @return returns the generic type found
     */
    public T sortAndSearch(T[] array){
        sorts.sort(array);
        return search.find(array);
    }

    @Override
    public String toString() {
        return "MySortAndSearch{" +
                "search=" + search +
                ", sorts=" + sorts +
                '}';
    }
}
