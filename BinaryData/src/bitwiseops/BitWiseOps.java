package bitwiseops;

public class BitWiseOps {

    public static void main(String[] args) {
        int number = 25;

        // assigning a binary sequence of 1 and 0 to number
        number = 0b1110_0000;

        // complement operator - flips the bits, similar to the not operator !false
        number = ~number;

        // print out number
        System.out.println(Integer.toBinaryString(number));
        System.out.println(number);
        // bitwiseAnd();
        bitShift();
    }

    public static void bitwiseAnd() {
        int a = 0b0100_1111;
        int b = 0b0010_1010;

        int c = a & b;
    }

    public static void bitShift() {
        int number = 0b0011_1111;

        int shifted = number << 2;

        System.out.println(shifted);

        // shift left by 1 bit
        int num = 2;
        System.out.println(num << 1); // * by 2
        System.out.println(num << 2); // * by 4

    }

}
