package threadsafety;

import java.util.*;

public class SharedData {

    private List<String> list;

    public SharedData() {
        this.list = new Vector<>();
    }

    // add string to end of list
    public void add(String s){
        list.add(s);
    }

    // remove string from front of list
    public void remove(){
        if (list.size() != 0)
             list.remove(0);
    }

    public int size(){
        return list.size();
    }
    public String toString(){
        return list.toString();
    }
}
