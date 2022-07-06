public class MemoryStack {

    private static int count;

    public static void main(String[] args) {

        recurse();

    }

    // recursive method - infinite recursion
    public static void recurse(){
        count++;
        System.out.println(count);
        recurse();
    }
}
