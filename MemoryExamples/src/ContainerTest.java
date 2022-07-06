import java.util.*;

public class ContainerTest {

    public static void main(String[] args) {
        List <String> myList = new ArrayList<>(Arrays.asList("cat", "dog", "frog"));

        Container c = new Container(myList);

        myList.set(0, "wolf");
        System.out.println(myList);
        System.out.println(c.getList());
    }
}
