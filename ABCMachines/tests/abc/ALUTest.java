/**
 *  Author: Cesar Escalona
 *  Sdev301 - Systems Programming
 *  3/3/21
 *  This Test program will test cases for the ALU Class in the Constructor,
 *  Addition, Subtraction, Division, and Multiplication
 */

package abc;

import org.junit.Test;
import static org.junit.Assert.*;

public class ALUTest {

    // default alu value should be Nzp.ZERO
    @Test
    public void testConstructor() {
        ALU alu = new ALU();
        assertEquals(Nzp.ZERO, alu.getStatus());
    }

    // Will test addition with an expected positive, negative, and zero
    // NZP should match positive, negative or zero
    @Test
    public void testAddition() {
        ALU alu = new ALU();

        // test positive sum
        assertEquals(5, alu.operate((byte)2, Operator.ADD, (byte)3));
        assertEquals(Nzp.POSITIVE, alu.getStatus());

        // test Negative sum
        assertEquals(-1, alu.operate((byte)2, Operator.ADD, (byte)-3));
        assertEquals(Nzp.NEGATIVE, alu.getStatus());

        // test Zero sum
        assertEquals(0, alu.operate((byte)5, Operator.ADD, (byte)-5));
        assertEquals(Nzp.ZERO, alu.getStatus());
    }

    // Will test subtraction with an expected positive, negative, and zero
    // NZP should match positive, negative or zero
    @Test
    public void testSubtraction(){
        ALU alu = new ALU();

        // test positive sub
        assertEquals(2, alu.operate((byte)5, Operator.SUB, (byte)3));
        assertEquals(Nzp.POSITIVE, alu.getStatus());

        // test Negative sub
        assertEquals(-2, alu.operate((byte)3, Operator.SUB, (byte)5));
        assertEquals(Nzp.NEGATIVE, alu.getStatus());

        // test Zero sub
        assertEquals(0, alu.operate((byte)5, Operator.SUB, (byte)5));
        assertEquals(Nzp.ZERO, alu.getStatus());
    }

    // Will test division with an expected positive, negative, and zero
    // NZP should match positive, negative or zero
    // Note: cannot divide by 0, if so system will throw IllegalArgumentException
    // and display a message that you can't divide by 0
    @Test
    public void testDivision() {
        ALU alu = new ALU();

        // test positive div
        assertEquals(1, alu.operate((byte)5, Operator.DIV, (byte)5));
        assertEquals(Nzp.POSITIVE, alu.getStatus());

        // Test negative div
        assertEquals(-8, alu.operate((byte)-48, Operator.DIV, (byte)6));
        assertEquals(Nzp.NEGATIVE, alu.getStatus());

        // Test Zero div
        assertEquals(0, alu.operate((byte)0, Operator.DIV, (byte)5));
        assertEquals(Nzp.ZERO, alu.getStatus());
    }

    // Will test multiplication with an expected positive, negative, and zero
    // NZP should match positive, negative or zero
    @Test
    public void testMultiplication() {
        ALU alu = new ALU();

        // test positive multi
        assertEquals(25, alu.operate((byte)5, Operator.MULT, (byte)5));
        assertEquals(Nzp.POSITIVE, alu.getStatus());

        // test negative multi
        assertEquals(-25, alu.operate((byte)5, Operator.MULT, (byte)-5));
        assertEquals(Nzp.NEGATIVE, alu.getStatus());

        // test zero multi
        assertEquals(0, alu.operate((byte)5, Operator.MULT, (byte)0));
        assertEquals(Nzp.ZERO, alu.getStatus());
    }
}