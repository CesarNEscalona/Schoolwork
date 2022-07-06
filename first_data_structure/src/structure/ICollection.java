package structure;

import java.util.Iterator;

public interface ICollection<T> extends Iterable<T> {
    boolean add(T newElement);
    boolean contains(T element);
    boolean remove(T element);
    int size();
    boolean isEmpty();
}
