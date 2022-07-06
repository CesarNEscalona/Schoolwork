package twoscomplement;

public class TwosComp {

    public static void main(String[] args) {
        byte b = 0b0101_1100;
        //         8421 8421
        b = 0x5C; // hex base 16
        b = 017; //  octal 9
        // 1681
        System.out.println(Byte.MIN_VALUE);
        System.out.println(Byte.MAX_VALUE);
    }
}
