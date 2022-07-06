package assembly;

/**
 * We will use this complied class file to see what
 * your high level Java statements look like in the
 * Java Virtual Machine's Assembly like language
 *
 * To view the Byte Code created by the Java Compiler(javac)
 * Select/Open Assembly.class located in out-->production-->Assembly-->assembly-->Assembly.class
 * From the intelliJ Menu Bar, Select View-->Show ByteCode
 */
public class Assembly {

    public static void main(String[] args) {

       int num1 = 5;
       int total = num1 + 4;

       System.out.println("Total: " + total);
    }

}
