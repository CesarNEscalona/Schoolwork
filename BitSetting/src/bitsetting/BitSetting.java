package bitsetting;

public class BitSetting {

    public static void main(String[] args) {
        // how would I know the largest byte integer that could be store in a byte variable?
        // byte - 8bits  short - 16 bits int - 32 bits long - 64 bits
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);

        // Decimal 8         128  64  32 16  8  4 2 1
        byte pos_eight = 0b0000_1000;

        // neg_eight
        byte comp_eight = (byte)~pos_eight;
        // print out comp_eight
        System.out.println(comp_eight); // decimal value
        // print comp_eight as binary string
        System.out.println(Integer.toBinaryString(comp_eight));

        byte neg_eight = (byte)(comp_eight + 1);
        System.out.println(neg_eight); // decimal
        System.out.println(Integer.toBinaryString(neg_eight));

        byte number = 0b0101_1101;

        // call setBit and print out what it returns
        byte result = setBit(2,number);
        System.out.println(result); // decimal
        System.out.println(Integer.toBinaryString(result));

        byte res = unSetBit(3, number);
        System.out.println(res);
        System.out.println(Integer.toBinaryString(res));

        // test isSet
        System.out.println(isSet(4, (byte)0b0101_1111));

        // should return false
        System.out.println(isSet(6, (byte)0b0101_1111));

        long mask = 1L << 33;
        System.out.println(mask);

    }
    // *** This will be helpful in the magic squares assignment ***
    // number 0101 1101  bitNum = 2
    // number 0101 1111
    public static byte setBit(int bitNum,byte number){
        // create a mask that has 0000 0010
        // 0000_0001
        // shifts over <<2 spots then -1 makes is go back one spot
        byte mask = (byte)(0b0000_0001 << bitNum - 1); // mask after shift 0000_0010
        // how do we set the bitNum in number? using |
        // make sure to Cast the (byte) so that it's not compiling errors.
        number = (byte)(number | mask);
        return number;
    }

    // number 0101 1101  bitNum = 3
    // number 0101 1001
    public static byte unSetBit(int bitNum,byte number){
        // create a mask that has 0000 0100
        // 0000_0001
        byte mask = (byte)(0b0000_0001 << bitNum - 1); // mask after shift 0000_0100
        // how do we turn 0000_0100 into 1111_1011?
        mask = (byte) ~mask; // 1101_1011

        // how do we un set the BitNum in number? use &
        //  0101 1101 number
        //& 1111 1011 mask
        //  0101 1001 result

        // make sure to Cast the (byte) so that it's not compiling errors.
        number = (byte)(number & mask);
        return number;
    }

    // number 0101 1111   bitNum 4 return true  bitNum 6 return false
    public static boolean isSet(int bitNum, byte number) {
        // create a mask
        byte mask = (byte) (0b0000_0001 << bitNum - 1);
        // perform a bitWise operation
        byte result = (byte) (mask & number);
        //return true or false based on something
        return result == mask;
    }
}
