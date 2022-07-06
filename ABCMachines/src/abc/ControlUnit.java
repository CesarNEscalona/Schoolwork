/**
 * This class represents the Control Unit for the
 * ABC Machine
 * author: Cesar Escalona
 * Sdev 301 - Systems Programming
 * 3/3/21
 */

package abc;

public class ControlUnit {

    private ABCMachine machine;

    /**
     * @param machine The ABC machine this ControlUnit belongs to
     */
    public ControlUnit(ABCMachine machine) {
        this.machine = machine;
    }

    /**
     * This method will continuously fetch, decode, execute, and store instructions/data that are
     * loaded into the ABCMachine's memory map. The program "halts" when it reaches an instruction
     * that is zero.
     */
    public void startProcessing() {
        while (!halt()) {
            fetch();
            decodeExecuteStore();
        }
    }

    /**
     *  This method performs the fetch step for the ControlUnit
     *  1. Access the memory address for the next instruction in RAM(memory array) (use the PC register)
     *  2. Load this instruction from memory into the Instruction Register  (IR)
     *  3. Increment the Program Counter (PC) register
     */
    public void fetch() {
        // get the memory array and save it to local variable
        short[] memory = machine.getMemory();
        // get the program counter
        byte pc = machine.getPc();
        short nextInstruction = memory[pc];

        // place nextInstruction into machine's IR
        machine.setIr(nextInstruction);

        // increment the program counter and set it for the machine
        machine.setPc(++pc);
    }

    /**
     *  This method decodes and executes the instruction according to the
     *  ABCMachine Instruction Set and stores the result
     */
    public void decodeExecuteStore() {
        byte opcode = getOpcode();

        switch(opcode) {

            case 0: //ADD src1 + src2 = dest
                short[] registers = machine.getRegisters();
                byte src1 = getSrc1Register();
                byte src2 = getSrc2Register();
                registers[getDestRegister()] = (short)(registers[src1] + registers[src2]);
                break;

            case 1: //SUB src1 - src2 = dest
                registers = machine.getRegisters();
                src1 = getSrc1Register();
                src2 = getSrc2Register();
                registers[getDestRegister()] = (short)(registers[src1] - registers[src2]);
                break;

            case 2: //MULT src1 * src2 = dest
                registers = machine.getRegisters();
                src1 = getSrc1Register();
                src2 = getSrc2Register();
                registers[getDestRegister()] = (short)(registers[src1] * registers[src2]);
                break;

            case 3: //DIV src1 / src2 = dest
                registers = machine.getRegisters();
                src1 = getSrc1Register();
                src2 = getSrc2Register();
                registers[getDestRegister()] = (short)(registers[src1] / registers[src2]);
                break;

            case 4: //STORE register src1 into memory address
                short[] memory = machine.getMemory();
                byte addr = getMemAddr();
                registers = machine.getRegisters();
                src1 = getSrc1Register();
                memory[addr] = registers[src1];
                break;

            case 5: //LOAD memory address into register src1
                memory = machine.getMemory();
                addr = getMemAddr();
                registers = machine.getRegisters();
                src1 = getSrc1Register();
                registers[src1] = memory[addr];
                break;

            case 6: //BRANCH
                byte nzp = getSrc1Register(); // 100-Neg  010-Zero  001-Positive
                addr = getMemAddr();
                if(machine.getAlu().getStatus() == Nzp.NEGATIVE && nzp == 0b100) {
                    // jump to address by setting pc to addr
                    machine.setPc(addr);
                }
                // else if NZP.POSITIVE and nzp == ?
                else if (machine.getAlu().getStatus() == Nzp.POSITIVE && nzp == 0b001) {
                    machine.setPc(addr);
                }
                // else if Nzp.ZERO and nzp == 0
                else if (machine.getAlu().getStatus() == Nzp.ZERO && nzp == 0b010) {
                    machine.setPc(addr);
                }
                break;

            case 7: //JMP
                addr = getMemAddr();
                machine.setPc(addr);
                break;
        }
    }

    /**
     *  This method returns the numerical value stored in bits numbered 14 - 16
     *  of the instruction register (IR) so the proper opcode can be determined
     *  IR     1  1  1  0   0  0  0  0   0  0  0  0   0  0  0  0
     *  Bit # 16 15 14 13  12 11 10  9   8  7  6  5   4  3  2  1
     *
     * @return a number in range 0 - 7
     * 000 - ADD,  001 - SUB, 010 - MULT, 011 - DIV, 100 - ST(ORE), 101 - LD (LOAD)
     * 110 - BR (BRANCH), 111 - JMP (JUMP)
     */
    public byte getOpcode() {
        // decode the opcode
        final short SHIFT = 13;
        final short MASK = 0b0000_0111;
        short ir = machine.getIr();
        return (byte)(ir >>> SHIFT & MASK);
    }

    /**
     * This method returns the numerical value stored in bits numbered 11 - 13
     * of the instruction register (IR)
     * IR     0  0  0  1   1  1  0  0   0  0  0  0   0  0  0  0
     * Bit # 16 15 14 13  12 11 10  9   8  7  6  5   4  3  2  1
     *
     * @return a number in range 0 - 7 - indicates
     */
    public byte getSrc1Register() {
        final short SHIFT = 10;
        final short MASK = 0b0000_0111;
        short ir = machine.getIr();
        return (byte)(ir >>> SHIFT & MASK);
    }

    /**
     * This method returns the numerical value stored in bits numbered 8 - 10
     * of the instruction register (IR)
     * IR     0  0  0  0   0  0  1  1   1  0  0  0   0  0  0  0
     * Bit # 16 15 14 13  12 11 10  9   8  7  6  5   4  3  2  1
     *
     * @return a number in range 0 - 7
     */
    public byte getSrc2Register() {
        final short SHIFT = 7;
        final short MASK = 0b0000_0111;
        short ir = machine.getIr();
        return (byte)(ir >>> SHIFT & MASK);
    }

    /**
     * This method returns the numerical value stored in bits numbered 5 - 7
     * of the instruction register (IR)
     * IR     0  0  0  0   0  0  0  0   0  1  1  1   0  0  0  0
     * Bit # 16 15 14 13  12 11 10  9   8  7  6  5   4  3  2  1
     *
     * @return a number in range 0 - 7
     */
    public byte getDestRegister() {
        final short SHIFT = 4;
        final short MASK = 0b0000_0111;
        short ir = machine.getIr();
        return (byte)(ir >>> SHIFT & MASK);
    }

    /**
     * This method returns the numerical value stored in bits numbered 1 - 4
     * of the instruction register (IR)
     * IR     0  0  0  0   0  0  0  0   0  0  0  0   1  1  1  1
     * Bit # 16 15 14 13  12 11 10  9   8  7  6  5   4  3  2  1
     *
     * @return a number in range 0 - 15
     */
    public byte getMemAddr() {
        final short SHIFT = 0;
        final short MASK = 0b0000_1111;
        short ir = machine.getIr();
        return (byte)(ir >>> SHIFT & MASK);
    }

    /**
     * @return true if next instruction contains all zeros, otherwise false
     */
    public boolean halt() {
        return machine.getMemory()[machine.getPc()] == 0;
    }
}