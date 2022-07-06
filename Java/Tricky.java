
	public class Mantra {
    public static void main(String[] args) {
        message1();
        message2();
        System.out.println("Done with main.");
    }

    public static void msg1() {
        System.out.println("There's one thing every coder must understand:");
        System.out.println("The System.out.prin");
    }

    public static void msg2() {
        System.out.println("This is message2.");
        message1();
        System.out.println("Done with message2.");
    }
}