import java.util.*;

public class Container {

    private List<String> list;

    public List<String> getList() {
        return list;
    }

    public Container(List<String> list) {
        this.list = list;   // shallow copy
        // make a deep copy of the list
        this.list = new ArrayList<>();
        for (String s : list) {
            this.list.add(s);
        }
    }
}
