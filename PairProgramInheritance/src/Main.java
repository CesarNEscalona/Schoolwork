import java.awt.*;

public class Main {
    public static void main(String[] args){
        String[] messages = {"yes", "no", "maybe", "definitely not", "without a doubt", "most likely", "signs point to yes", "outlook bad"};

        MagicEightBall run = new MagicEightBall(Color.BLACK, messages);

        System.out.println(run.shake());
        System.out.println("");

        System.out.println(run.shake());
        System.out.println("");

        System.out.println(run.shake());
        System.out.println("");

        System.out.println(run.shake());
        System.out.println("");

        System.out.println(run.shake());
        System.out.println("");
    }
}
