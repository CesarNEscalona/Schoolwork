import java.util.ArrayList;
import java.util.Scanner;

public class Test {


    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("Please enter a number: ");
        int num1 = Input.nextInt();
        list.add(num1);
    }
}
