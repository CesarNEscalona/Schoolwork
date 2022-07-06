package structures;

import helpers.KeyValuePair;
import interfaces.ICollection;
import interfaces.IMap;
import interfaces.ISet;

import java.util.Iterator;

/**
 * Map class that implements IMap methods and ICollection methods.
 *
 * @param <K> key returns the key in a key value pair
 * @param <V> value returns the value in a key value pair
 * @author Cesar Escalona
 * @version 1.0
 */
public class Map<K, V> implements IMap<K, V>
{
    // instance variable
    private HashTable<KeyValuePair<K, V>> table = new HashTable<>();

    /**
     * Adds a key/value pair to the map. If the key already exists
     * in the map then this will update the value associated with
     * the key.
     *
     * @param key the key
     * @param value the value
     */
    @Override
    public void add(K key, V value)
    {
        KeyValuePair<K,V> pair = new KeyValuePair<>(key, value);
        table.add(pair);
    }

    /**
     * Removes a key (and the associated value) from the map. If
     * no key is found matching the input parameter, then no change
     * is made to the map.
     * @param key the key
     */
    @Override
    public void remove(K key)
    {
        // create a pair, then retrieve the key
        KeyValuePair<K,V> pair = new KeyValuePair<>(key, null);
        // if the key does not exist, no change is made
        table.remove(pair);
    }

    /**
     * Returns the value associated with a key.
     *
     * @param key the key
     * @return the value associated with the key
     */
    @Override
    public V get(K key)
    {
        // create a pair and pass the pair to a variable
        KeyValuePair<K,V> pair = new KeyValuePair<>(key, null);
        KeyValuePair<K,V> result = table.get(pair);
        // if the result is null then we can't get a value, other wise enter and get the value
        if(result != null){
            return result.getValue();
        } else {
            return null;
        }
    }

    /**
     * Reports whether the input key is in the map.
     *
     * @param key the key
     * @return true if the key is in the map, otherwise false
     */
    @Override
    public boolean keyExists(K key)
    {
        KeyValuePair<K,V> pair = new KeyValuePair<>(key, null);
        return table.contains(pair);
    }

    /**
     * Reports whether the input value is in the map.
     *
     * @param value the value
     * @return true if the value is in the map, otherwise false
     */
    @Override
    public boolean valueExists(V value)
    {
        // loop through the items in the table
        for (KeyValuePair<K,V> item: table) {
            // if this value equals other value then the value exists
            if(item.getValue().equals(value)){
                return true;
            }
        }
        // false if the value doesn't exist
        return false;
    }

    /**
     * Returns the number of key/value pairs in the map.
     *
     * @return the number of elements
     */
    @Override
    public int size()
    {
        // constant return of the table size
        return table.size();
    }

    /**
     * Reports whether the map is empty or not.
     *
     * @return true if no key/value pairs are in the map, otherwise
     * false
     */
    @Override
    public boolean isEmpty()
    {
        // constant return of the table is empty
        return table.isEmpty();
    }

    /**
     * Removes all key/value pairs in the map.
     */
    @Override
    public void clear()
    {
        // constant clearing of the table
        table.clear();
    }

    /**
     * Returns an iterator over the key/value pairs in the map.
     *
     * @return an iterator using the Iterator<T> interface.
     */
    @Override
    public Iterator<KeyValuePair<K, V>> iterator()
    {
        // constant return of the table iterator
        return table.iterator();
    }

    /**
     * Returns an ISet<K> object with the all keys in the map.
     *
     * @return a set of keys
     */
    @Override
    public ISet<K> keyset()
    {
        // create a new set
        Set<K> result = new Set<>();

        // place every item in the table to the set and return the set
        for (KeyValuePair<K,V> item: table) {
            result.add(item.getKey());
        }
        return result;
    }

    /**
     * Returns an ICollection<V> object with all values in the map.
     *
     * @return a collection of values
     */
    @Override
    public ICollection<V> values()
    {
        // create a new set
        Set<V> result = new Set<>();

        // place every items value into the set and return the set
        for (KeyValuePair<K,V> item: table) {
            result.add(item.getValue());
        }
        return result;
    }

    /**
     * Returns a generic toString
     *
     * @return a toString
     */
    @Override
    public String toString() {
        return "Map{" +
                "table=" + table +
                '}';
    }
}
