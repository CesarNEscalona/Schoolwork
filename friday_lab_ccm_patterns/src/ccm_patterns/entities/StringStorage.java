package ccm_patterns.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * This class was updated by adding a Memento inner class to implement the Memento Pattern
 *
 * @author Cesar Escalona
 * @version 1.0
 */
//This class is not mutable, unlike the String class.
public class StringStorage
{
    private String data;

    /**
     * @param data the string data passed in by a User
     */
    public StringStorage(String data)
    {
        this.data = data;
    }

    /**
     * @return returns a memento object
     */
    public Memento createMemento(){
        Memento memento = new Memento();
        memento.set("data", data);
        return memento;
    }

    /**
     * @param memento the memento that is being updated
     */
    public void setMemento(Memento memento){
        data = memento.get("data").toString();
    }

    /**
     * @return returns the string passed into a String Storage obj
     */
    public String getData()
    {
        return data;
    }

    /**
     * @param data the updated string in string storage
     */
    public void setData(String data)
    {
        this.data = data;
    }

    // Create Memento Inner Class that stores snapshot in hashmap
    public class Memento {
        private Map<String, Object> data;

        /**
         * Default constructor that instantiates the hashmap
         */
        public Memento() {
            this.data = new HashMap<>();
        }

        private void set(String key, Object value){
            data.put(key, value);
        }

        private Object get(String key){
            return data.get(key);
        }

        @Override
        public String toString() {
            return "Memento{" +
                    "data=" + data +
                    '}';
        }
    }

    @Override
    public String toString()
    {
        return data;
    }
}
