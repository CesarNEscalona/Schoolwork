/**
 *  Author: Cesar Escalona
 *  Sdev 301 - Systems Programming
 *  3/3/21
 *  This program is in charge of performing all the arithmetic instructions and
 *  this class stores the NZP indicator.
 */

package abc;

public class ALU {

    private Nzp status; //holds Nzp.NEGATIVE, Nzp.ZERO, or Nzp.POSITIVE

    // Initialize the ALU status to Nzp.ZERO
    public ALU() {
        status = Nzp.ZERO;
    }

    /** This method will perform a math operation on two numbers and set the nzp status
     * appropriately based on whether the math operation resulting in a positive, negative, or zero value
     */
    public short operate(short num1, Operator operator, short num2) throws IllegalArgumentException {
        short answer = 0;

        if(operator == Operator.DIV) {
            if(num2 == 0) {
                throw new IllegalArgumentException("Cannot divide by 0");
            }
            answer = (short)(num1 / num2);
        }
        if(operator == Operator.ADD) {
            answer = (short)(num1 + num2);
        }
        if(operator == Operator.SUB) {
            answer = (short)(num1 - num2);
        }
        if(operator == Operator.MULT) {
            answer = (short)(num1 * num2);
        }
        // setting status
        setStatus(answer);

        return answer;//answer to ADD, SUB, MULT, DIV
    }

    // Helper method that sets the status of Nzp
    private void setStatus(short answer) {
        if(answer < 0){
            status = Nzp.NEGATIVE;
        }
        if(answer == 0){
            status = Nzp.ZERO;
        }
        if(answer > 0){
            status = Nzp.POSITIVE;
        }
    }

    // returns the status of Nzp either POS, NEG or ZERO
    public Nzp getStatus() {
        return status;
    }
}